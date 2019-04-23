package com.abhie.mvp.di.component

import android.app.Application
import com.abhie.mvp.BaseApp
import com.abhie.mvp.di.builder.ActivityBuilder
import com.abhie.mvp.di.module.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [(AndroidInjectionModule::class), (AppModule::class), (ActivityBuilder::class)])
interface AppComponent {

    @Component.Builder
    interface Builder{
        @BindsInstance
        fun application(app: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: BaseApp)
}