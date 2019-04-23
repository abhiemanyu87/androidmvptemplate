package com.abhie.mvp.data.pref

import android.content.Context
import android.content.SharedPreferences
import android.os.Build
import com.abhie.mvp.data.net.AuthResponse
import com.abhie.mvp.di.PreferenceInfo
import java.util.*
import javax.inject.Inject

class AppPreferenceHelper @Inject constructor(context: Context, @PreferenceInfo private val prefName: String) :
    PreferenceHelper {
    companion object {

        private val PREF_KEY_FIRST_TIME = "PREF_KEY_FIRST_TIME"

        val KEY_TIMESTAP = "timestamp_login"

        val KEY_EMAIL = "email_login"
        val KEY_FULLNAME = "fullname_login"
        val KEY_USERNAME = "username_login"
        val KEY_PHONE = "phone_login"
        val KEY_GUID = "guid_login"
        val KEY_DEV_NAME = "device_name"
        val KEY_TOKEN = "token_login"
        private val TAG = "AppPreferencesHelper"
        private val PREF_KEY_IS_FIRST = "KEY_FIRST_TIME"
        private val PREF_KEY_SHOW_REGISTER_FORM = "KEY_SHOW_REGISTER_FORM"
        private val KEY_IDENTITY = "identity"
    }
    private val mPrefs: SharedPreferences = context.getSharedPreferences(prefName, Context.MODE_PRIVATE)
    override fun isUserFirstTime(): Boolean? = mPrefs.getBoolean(PREF_KEY_FIRST_TIME, true)

    override fun setUserFirstTime() {
        mPrefs.edit().putBoolean(PREF_KEY_FIRST_TIME, false).apply()
        val guid = UUID.randomUUID().toString()
        mPrefs.edit().putString(KEY_GUID, guid).apply()
        val vendor = Build.MANUFACTURER
        mPrefs.edit().putString(KEY_DEV_NAME, vendor).apply()
    }

    override fun getUser(): HashMap<String, String> {
        val user = HashMap<String, String>()

        user[KEY_EMAIL] = mPrefs.getString(KEY_EMAIL, "")!!
        user[KEY_FULLNAME] = mPrefs.getString(KEY_FULLNAME, "")
        user[KEY_PHONE] = mPrefs.getString(KEY_PHONE, "")
        user[KEY_USERNAME] = mPrefs.getString(KEY_USERNAME, "")
        user[KEY_GUID] = mPrefs.getString(KEY_GUID, "")
        user[KEY_DEV_NAME] = mPrefs.getString(KEY_DEV_NAME, "")
        user[KEY_TIMESTAP] = mPrefs.getLong(KEY_TIMESTAP, -1L).toString()
        user[KEY_TOKEN] = mPrefs.getString(KEY_TOKEN, "").toString()

        return user
    }

    override fun setLogin(login: AuthResponse.LoginResponse) {
        mPrefs.edit().putString(KEY_EMAIL, login.loginData!!.email).apply()
        mPrefs.edit().putString(
            KEY_FULLNAME,
            login.loginData!!.firstname + " " + login.loginData!!.lastname
        ).apply()
        mPrefs.edit().putString(KEY_USERNAME, login.loginData!!.username).apply()
        mPrefs.edit().putString(KEY_PHONE, login.loginData!!.phone).apply()
        mPrefs.edit().putString(KEY_TOKEN, login.token).apply()
    }
}
