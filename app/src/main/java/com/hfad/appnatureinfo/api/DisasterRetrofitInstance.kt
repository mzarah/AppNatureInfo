package com.hfad.appnatureinfo.api

import com.hfad.appnatureinfo.utils.Contants.Companion.DISASTER_BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object DisasterRetrofitInstance {


    private val retrofit by lazy {
        Retrofit.Builder()
                .baseUrl(DISASTER_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }


    val api: DisasterApi by lazy {
        retrofit.create(DisasterApi::class.java)
    }
}