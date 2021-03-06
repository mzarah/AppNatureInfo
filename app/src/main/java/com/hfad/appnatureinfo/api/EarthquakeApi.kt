package com.hfad.appnatureinfo.api

import com.hfad.appnatureinfo.model.EarthquakeResponseData
import retrofit2.Response
import retrofit2.http.GET

interface EarthquakeApi {

    @GET("event/1/query?format=geojson")
    suspend fun getEarthquakeResponse(): Response<EarthquakeResponseData>
}