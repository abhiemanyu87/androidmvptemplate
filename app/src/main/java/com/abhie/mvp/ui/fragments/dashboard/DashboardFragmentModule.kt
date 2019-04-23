package com.abhie.mvp.ui.fragments.dashboard

import com.abhie.mvp.ui.fragments.dashboard.interactor.DashboardInteractor
import com.abhie.mvp.ui.fragments.dashboard.interactor.DashboardMVPInteractor
import com.abhie.mvp.ui.fragments.dashboard.presenter.DashboardMVPPresenter
import com.abhie.mvp.ui.fragments.dashboard.presenter.DashboardPresenter
import com.abhie.mvp.ui.fragments.dashboard.view.DashboardMVPView
import dagger.Module
import dagger.Provides


@Module
class DashboardFragmentModule {

    @Provides
    internal fun provideDashboardInteractor(interactor: DashboardInteractor): DashboardMVPInteractor = interactor

    @Provides
    internal fun provideDashboardPresenter(presenter: DashboardPresenter<DashboardMVPView, DashboardMVPInteractor>):
            DashboardMVPPresenter<DashboardMVPView, DashboardMVPInteractor> = presenter
}