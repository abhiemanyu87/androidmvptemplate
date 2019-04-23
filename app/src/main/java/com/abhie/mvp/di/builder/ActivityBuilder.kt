package com.abhie.mvp.di.builder

import com.abhie.mvp.ui.fragments.dashboard.DashboardFragmentProvider
import com.abhie.mvp.ui.home.Home
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [(DashboardFragmentProvider::class)])
    abstract fun bindHome() : Home
}