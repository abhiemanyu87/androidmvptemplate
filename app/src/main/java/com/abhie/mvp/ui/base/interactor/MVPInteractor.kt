package com.abhie.mvp.ui.base.interactor

/**
 * Created by jyotidubey on 04/01/18.
 */
interface MVPInteractor {

    fun isUserLoggedIn(): Boolean

    fun performUserLogout()

}