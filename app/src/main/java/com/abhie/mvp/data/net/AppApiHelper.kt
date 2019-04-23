package com.abhie.mvp.data.net

import com.rx2androidnetworking.Rx2AndroidNetworking
import io.reactivex.Observable
import javax.inject.Inject

class AppApiHelper @Inject constructor(private val apiHeader: ApiHeader) : ApiHelper {
    override fun login(request: AuthRequest.Login): Observable<AuthResponse.LoginResponse> =
        Rx2AndroidNetworking.post(ApiEndPoint.ENDPOINT_LOGIN)
            .addHeaders(apiHeader)
            .addBodyParameter("uname", request.uname)
            .addBodyParameter("pwd", request.password)
            .addBodyParameter("dev_id", request.devId)
            .addBodyParameter("tipe", "1")
            .setContentType("application/x-www-form-urlencoded")
            .build()
            .getObjectObservable(AuthResponse.LoginResponse::class.java)
}