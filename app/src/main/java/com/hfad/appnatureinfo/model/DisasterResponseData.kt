package com.hfad.appnatureinfo.model


import com.google.gson.annotations.SerializedName

data class DisasterResponseData(
    @SerializedName("DisasterDeclarationsSummaries")
    val disasterDeclarationsSummaries: List<DisasterDeclarationsSummary>,

)