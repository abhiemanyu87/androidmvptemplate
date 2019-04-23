package com.abhie.mvp.data.pref

import com.abhie.mvp.data.net.AuthResponse
import java.util.HashMap

interface PreferenceHelper {

    fun isUserFirstTime(): Boolean?

    fun setUserFirstTime()

    fun getUser(): HashMap<String, String>

    fun setLogin(login: AuthResponse.LoginResponse)

}