package com.abhie.mvp.ui.base.interactor

import com.abhie.mvp.data.db.AppDatabase
import com.abhie.mvp.data.net.ApiHelper
import com.abhie.mvp.data.pref.PreferenceHelper

/**
 * Created by jyotidubey on 04/01/18.
 */
open class BaseInteractor() : MVPInteractor {


    protected lateinit var preferenceHelper: PreferenceHelper
    protected lateinit var apiHelper: ApiHelper
    protected lateinit var dbHelper: AppDatabase

    constructor(preferenceHelper: PreferenceHelper, apiHelper: ApiHelper, dbHelper: AppDatabase) : this() {
        this.preferenceHelper = preferenceHelper
        this.apiHelper = apiHelper
        this.dbHelper = dbHelper
    }

//    override fun isUserLoggedIn() = this.preferenceHelper.getCurrentUserLoggedInMode() != AppConstants.LoggedInMode.LOGGED_IN_MODE_LOGGED_OUT.type

    override fun performUserLogout() = preferenceHelper.let {
//        it.setCurrentUserId(null)
//        it.setAccessToken(null)
//        it.setCurrentUserEmail(null)
        //it.setCurrentUserLoggedInMode(AppConstants.LoggedInMode.LOGGED_IN_MODE_LOGGED_OUT)
    }

    override fun isUserLoggedIn(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}