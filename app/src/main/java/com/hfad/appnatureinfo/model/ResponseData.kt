package com.hfad.appnatureinfo.model


import com.google.gson.annotations.SerializedName

data class ResponseData(
    @SerializedName("features")
    val features: List<Feature>,
    @SerializedName("metadata")
    val metadata: Metadata,
    @SerializedName("type")
    val type: String
)