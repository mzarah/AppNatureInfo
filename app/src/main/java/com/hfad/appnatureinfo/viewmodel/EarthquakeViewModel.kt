package com.hfad.appnatureinfo.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hfad.appnatureinfo.model.EarthquakeResponseData
import com.hfad.appnatureinfo.repository.NetworkState
import com.hfad.appnatureinfo.repository.EarthquakeRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import java.lang.Exception

class EarthquakeViewModel(private val repository: EarthquakeRepository): ViewModel() {

    val earthquakeResponse: MutableLiveData<Response<EarthquakeResponseData>> = MutableLiveData()
    val networkState = MutableLiveData<NetworkState>()

    fun getEarthquake() {
        networkState.postValue(NetworkState.LOADING)
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response: Response<EarthquakeResponseData> = repository.getEarthquakeResponse()
                earthquakeResponse.postValue(response)
                networkState.postValue(NetworkState.LOADED)
            }
            catch (e: Exception){
                Log.d("EarthquakeViewM class", e.message)
            }
        }
    }

}