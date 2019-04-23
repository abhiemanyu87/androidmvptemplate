package com.abhie.mvp.ui.fragments.dashboard.presenter

import com.abhie.mvp.ui.base.presenter.MVPPresenter
import com.abhie.mvp.ui.fragments.dashboard.interactor.DashboardMVPInteractor
import com.abhie.mvp.ui.fragments.dashboard.view.DashboardMVPView

interface DashboardMVPPresenter<V : DashboardMVPView, I : DashboardMVPInteractor>: MVPPresenter<V,I> {
}