package com.hfad.appnatureinfo.model


import com.google.gson.annotations.SerializedName

data class Properties(
    @SerializedName("mag")
    val mag: String,
    @SerializedName("place")
    val place: String,
    @SerializedName("time")
    val time: String,
)

