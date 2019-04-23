package com.abhie.mvp.data.net

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class AuthRequest {

    data class Register internal constructor(
        @Expose
        @SerializedName("email")
        internal val email: String,

        @Expose
        @SerializedName("fname")
        internal val fullname: String,

        @Expose
        @SerializedName("passwd1")
        internal val password: String,

        @Expose
        @SerializedName("gender")
        internal val gender: String,

        @Expose
        @SerializedName("dev_id")
        internal val devId: String,

        @Expose
        @SerializedName("dev_name")
        internal val devName: String
    )

    data class Login internal constructor(
        @Expose
        @SerializedName("uname")
        internal val uname: String,

        @Expose
        @SerializedName("pwd")
        internal val password: String,

        @Expose
        @SerializedName("dev_id")
        internal val devId: String,

        @Expose
        @SerializedName("tipe")
        internal val gender: String = "1"
    )
}