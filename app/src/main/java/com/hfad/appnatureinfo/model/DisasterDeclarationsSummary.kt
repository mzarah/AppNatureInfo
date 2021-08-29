package com.hfad.appnatureinfo.model


import com.google.gson.annotations.SerializedName

data class DisasterDeclarationsSummary(
    @SerializedName("declarationDate")
    val declarationDate: String,
    @SerializedName("declarationRequestNumber")
    val declarationRequestNumber: String,
    @SerializedName("declarationTitle")
    val declarationTitle: String,
    @SerializedName("declarationType")
    val declarationType: String,
    @SerializedName("designatedArea")
    val designatedArea: String,
    @SerializedName("disasterCloseoutDate")
    val disasterCloseoutDate: String,
    @SerializedName("disasterNumber")
    val disasterNumber: Int,
    @SerializedName("femaDeclarationString")
    val femaDeclarationString: String,
    @SerializedName("fipsCountyCode")
    val fipsCountyCode: String,
    @SerializedName("fipsStateCode")
    val fipsStateCode: String,
    @SerializedName("fyDeclared")
    val fyDeclared: Int,
    @SerializedName("hash")
    val hash: String,
    @SerializedName("hmProgramDeclared")
    val hmProgramDeclared: Boolean,
    @SerializedName("iaProgramDeclared")
    val iaProgramDeclared: Boolean,
    @SerializedName("id")
    val id: String,
    @SerializedName("ihProgramDeclared")
    val ihProgramDeclared: Boolean,
    @SerializedName("incidentBeginDate")
    val incidentBeginDate: String,
    @SerializedName("incidentEndDate")
    val incidentEndDate: String,
    @SerializedName("incidentType")
    val incidentType: String,
    @SerializedName("lastRefresh")
    val lastRefresh: String,
    @SerializedName("paProgramDeclared")
    val paProgramDeclared: Boolean,
    @SerializedName("placeCode")
    val placeCode: String,
    @SerializedName("state")
    val state: String
)