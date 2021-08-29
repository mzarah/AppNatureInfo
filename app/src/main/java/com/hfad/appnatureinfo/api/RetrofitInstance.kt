package com.hfad.appnatureinfo.api

import com.hfad.appnatureinfo.utils.Contants.Companion.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitInstance {


    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }




    val api: EarthquakeApi by lazy {
        retrofit.create(EarthquakeApi::class.java)
    }
}