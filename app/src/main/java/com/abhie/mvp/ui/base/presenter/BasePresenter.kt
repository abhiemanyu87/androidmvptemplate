package com.abhie.mvp.ui.base.presenter

import com.androidnetworking.error.ANError
import com.abhie.mvp.ui.base.interactor.MVPInteractor
import com.abhie.mvp.ui.base.view.MVPView
import io.reactivex.disposables.CompositeDisposable
import com.med.kipinschool.utils.SchedulerProvider

/**
 * Created by jyotidubey on 04/01/18.
 */
abstract class BasePresenter<V : MVPView, I : MVPInteractor> internal constructor(protected var interactor: I?, protected val schedulerProvider: SchedulerProvider, protected val compositeDisposable: CompositeDisposable) :
    MVPPresenter<V, I> {

    private var view: V? = null
    private val isViewAttached: Boolean get() = view != null

    override fun onAttach(view: V?) {
        this.view = view
    }

    override fun getView(): V? = view

    override fun onDetach() {
        compositeDisposable.dispose()
        view = null
        interactor = null
    }

    override fun handleANError(throwable: Throwable) {
        val anError = throwable as ANError

//        val errorCode = anError.errorCode
//        val errorBody = anError.errorBody
        val errorDetail = anError.errorDetail

        getView()?.showMessage(errorDetail)
    }

}