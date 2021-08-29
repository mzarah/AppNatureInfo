package com.hfad.appnatureinfo.model


import com.google.gson.annotations.SerializedName


data class Feature(
    @SerializedName("id")
    val id: String,
    @SerializedName("properties")
    val properties: Properties,
)