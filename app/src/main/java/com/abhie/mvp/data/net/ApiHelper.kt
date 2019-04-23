package com.abhie.mvp.data.net

import io.reactivex.Observable

interface ApiHelper {

    fun login(request: AuthRequest.Login): Observable<AuthResponse.LoginResponse>
}