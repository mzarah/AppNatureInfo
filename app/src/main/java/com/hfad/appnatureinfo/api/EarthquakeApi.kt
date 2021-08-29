package com.hfad.appnatureinfo.api

import com.hfad.appnatureinfo.model.ResponseData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface EarthquakeApi {

    @GET("event/1/query?format=geojson")
    suspend fun getEarthquakeResponse(): Response<ResponseData>
}