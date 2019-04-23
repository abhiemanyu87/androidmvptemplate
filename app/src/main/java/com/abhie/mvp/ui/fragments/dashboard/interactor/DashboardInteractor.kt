package com.abhie.mvp.ui.fragments.dashboard.interactor

import com.abhie.mvp.data.db.AppDatabase
import com.abhie.mvp.data.net.ApiHelper
import com.abhie.mvp.data.pref.PreferenceHelper
import com.abhie.mvp.ui.base.interactor.BaseInteractor
import javax.inject.Inject

class DashboardInteractor @Inject internal constructor(preferenceHelper: PreferenceHelper, apiHelper: ApiHelper, dbHelper: AppDatabase) : BaseInteractor(preferenceHelper, apiHelper, dbHelper), DashboardMVPInteractor {
}