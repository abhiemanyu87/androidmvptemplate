package com.abhie.mvp

import android.app.Activity
import android.app.Application
import com.abhie.mvp.di.component.DaggerAppComponent
import com.tonyodev.fetch2.Fetch
import com.tonyodev.fetch2.FetchConfiguration
import com.tonyodev.fetch2core.FetchLogger
import com.tonyodev.fetch2okhttp.OkHttpDownloader
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import io.github.inflationx.calligraphy3.CalligraphyConfig
import io.github.inflationx.calligraphy3.CalligraphyInterceptor
import io.github.inflationx.viewpump.ViewPump
import okhttp3.OkHttpClient
import javax.inject.Inject

class BaseApp : Application(), HasActivityInjector{

    @Inject
    lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector(): AndroidInjector<Activity> = activityDispatchingAndroidInjector

    init {
        instance = this
    }

    override fun onCreate() {
        super.onCreate()

        DaggerAppComponent.builder()
            .application(this)
            .build()
            .inject(this)

        ViewPump.init(
            ViewPump.builder()
                .addInterceptor(
                    CalligraphyInterceptor(
                        CalligraphyConfig.Builder()
                            .setDefaultFontPath("fonts/Nunito-Regular.ttf")
                            .setFontAttrId(R.attr.fontPath)
                            .build()
                    )
                ).build()
        )
    }

    companion object {

        lateinit var instance: BaseApp

        private lateinit var fetch: Fetch

        fun getFetch(): Fetch {
            val client = OkHttpClient.Builder().build()
            val okHttpDownloader = OkHttpDownloader(client)
            //            final Logger logger = new FetchTimberLogger();
            val logger = FetchLogger()
            val concurrentLimit = 2
            val enableLogging = true
            val config = FetchConfiguration.Builder(instance.applicationContext)
                .setLogger(logger)
                .setHttpDownloader(okHttpDownloader)
                .setDownloadConcurrentLimit(concurrentLimit)
                .enableLogging(enableLogging)
                .build()
            fetch = Fetch.Impl.getInstance(config)
            return fetch
        }
    }
}