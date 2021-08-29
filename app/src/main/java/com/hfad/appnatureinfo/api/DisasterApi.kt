package com.hfad.appnatureinfo.api

import com.hfad.appnatureinfo.model.DisasterResponseData
import com.hfad.appnatureinfo.model.EarthquakeResponseData
import retrofit2.Response
import retrofit2.http.GET

interface DisasterApi {

    @GET("DisasterDeclarationsSummaries")
    suspend fun getDisasterResponse(): Response<DisasterResponseData>
}