package com.abhie.mvp.ui.fragments.dashboard

import com.abhie.mvp.ui.fragments.dashboard.view.Dashboard
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class DashboardFragmentProvider {

    @ContributesAndroidInjector(modules = [(DashboardFragmentModule::class)])
    internal abstract fun provideLatestFragmentFactory(): Dashboard
}