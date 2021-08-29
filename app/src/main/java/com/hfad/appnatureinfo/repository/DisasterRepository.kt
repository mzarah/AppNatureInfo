package com.hfad.appnatureinfo.repository

import com.hfad.appnatureinfo.api.DisasterRetrofitInstance
import com.hfad.appnatureinfo.model.DisasterResponseData
import retrofit2.Response

class DisasterRepository {
    suspend fun getDisasterResponse(): Response<DisasterResponseData> {
        return DisasterRetrofitInstance.api.getDisasterResponse()
    }

}