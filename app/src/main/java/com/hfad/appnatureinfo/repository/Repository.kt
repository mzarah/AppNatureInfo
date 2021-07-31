package com.hfad.appnatureinfo.repository

import androidx.lifecycle.LiveData
import com.hfad.appnatureinfo.api.RetrofitInstance
import com.hfad.appnatureinfo.model.ResponseData
import retrofit2.Response

class Repository {
    suspend fun getEarthquakeResponse(): Response<ResponseData> {
        return RetrofitInstance.api.getEarthquakeResponse()
    }

}