package com.abhie.mvp.data.net

import com.abhie.mvp.di.ApiKeyInfo
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import javax.inject.Inject

class ApiHeader @Inject constructor(
        @ApiKeyInfo
        @Expose
        @SerializedName("AUTH")
        val apiKey: String
)