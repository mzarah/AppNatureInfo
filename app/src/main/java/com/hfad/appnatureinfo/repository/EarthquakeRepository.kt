package com.hfad.appnatureinfo.repository

import com.hfad.appnatureinfo.api.EarthquakeRetrofitInstance
import com.hfad.appnatureinfo.model.EarthquakeResponseData
import retrofit2.Response

class EarthquakeRepository {
    suspend fun getEarthquakeResponse(): Response<EarthquakeResponseData> {
        return EarthquakeRetrofitInstance.api.getEarthquakeResponse()
    }

}