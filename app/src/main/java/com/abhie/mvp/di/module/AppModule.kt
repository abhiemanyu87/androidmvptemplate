package com.abhie.mvp.di.module

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.abhie.mvp.BuildConfig
import com.abhie.mvp.data.db.AppDatabase
import com.abhie.mvp.data.net.ApiHelper
import com.abhie.mvp.data.net.AppApiHelper
import com.abhie.mvp.data.pref.AppPreferenceHelper
import com.abhie.mvp.data.pref.PreferenceHelper
import com.abhie.mvp.di.ApiKeyInfo
import com.abhie.mvp.di.PreferenceInfo
import com.abhie.mvp.utils.AppConstants
import com.med.kipinschool.utils.SchedulerProvider
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

@Module
class AppModule {
    @Provides
    @Singleton
    internal fun provideContext(application: Application): Context = application

    @Provides
    @Singleton
    internal fun provideAppDatabase(context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, AppConstants.APP_DB_NAME)
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @ApiKeyInfo
    internal fun provideApiKey(): String = BuildConfig.API_KEY

    @Provides
    @PreferenceInfo
    internal fun providePreferenceInfo(): String = AppConstants.PREF_NAME

    @Provides
    @Singleton
    internal fun provideApiHelper(appApiHelper: AppApiHelper): ApiHelper = appApiHelper

    @Provides
    @Singleton
    internal fun providePrefHelper(appPreferenceHelper: AppPreferenceHelper): PreferenceHelper = appPreferenceHelper

    @Provides
    internal fun provideCompositeDisposable(): CompositeDisposable = CompositeDisposable()

    @Provides
    internal fun provideSchedulerProvider(): SchedulerProvider = SchedulerProvider()
}