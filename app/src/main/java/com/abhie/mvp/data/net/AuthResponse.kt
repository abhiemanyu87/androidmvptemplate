package com.abhie.mvp.data.net

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class AuthResponse {

    data class RegisterResponse internal constructor(
        @Expose
        @SerializedName("status")
        private var status: Boolean? = null,

        @Expose
        @SerializedName("message")
        private var message: String? = null
    )

    data class LoginResponse internal constructor(
        @Expose
        @SerializedName("error")
        var error: Boolean? = null,

        @Expose
        @SerializedName("respond")
        var loginData: LoginData? = null,

        @Expose
        @SerializedName("status")
        var status: Boolean? = null,

        @Expose
        @SerializedName("expired")
        var expired: String? = null,

        @Expose
        @SerializedName("token")
        var token: String? = null,

        @Expose
        @SerializedName("message")
        var message: String? = null
    )

    data class LoginData(
        @Expose
        @SerializedName("_id")
        var id: String? = null,

        @Expose
        @SerializedName("ip_address")
        var ipAddress: String? = null,

        @Expose
        @SerializedName("username")
        var username: String? = null,

        @Expose
        @SerializedName("email")
        var email: String? = null,

        @Expose
        @SerializedName("first_name")
        var firstname: String? = null,

        @Expose
        @SerializedName("last_name")
        var lastname: String? = null,

        @Expose
        @SerializedName("timestamp")
        var timestamp: String? = null,

        @Expose
        @SerializedName("phone")
        var phone: String? = null,

        @Expose
        @SerializedName("dev_name")
        var devName: String? = null,

        @Expose
        @SerializedName("dev_id")
        var devId: String? = null,

        @Expose
        @SerializedName("isSubscribe")
        var isSubscribe: Boolean? = null
    )
}