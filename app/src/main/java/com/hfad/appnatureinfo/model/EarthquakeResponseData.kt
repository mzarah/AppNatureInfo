package com.hfad.appnatureinfo.model


import com.google.gson.annotations.SerializedName


data class EarthquakeResponseData(
    @SerializedName("features")
    val features: List<Feature>,
)