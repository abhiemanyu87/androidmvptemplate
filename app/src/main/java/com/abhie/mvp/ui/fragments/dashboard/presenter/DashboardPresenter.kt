package com.abhie.mvp.ui.fragments.dashboard.presenter

import com.abhie.mvp.ui.base.presenter.BasePresenter
import com.abhie.mvp.ui.fragments.dashboard.interactor.DashboardMVPInteractor
import com.abhie.mvp.ui.fragments.dashboard.view.DashboardMVPView
import com.med.kipinschool.utils.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class DashboardPresenter<V : DashboardMVPView, I : DashboardMVPInteractor>
@Inject constructor(interactor: I, schedulerProvider: SchedulerProvider, compositeDisposable: CompositeDisposable) :
    BasePresenter<V, I>(interactor = interactor, schedulerProvider = schedulerProvider, compositeDisposable = compositeDisposable),
    DashboardMVPPresenter<V, I> {
}