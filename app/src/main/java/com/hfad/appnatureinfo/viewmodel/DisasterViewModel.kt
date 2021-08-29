package com.hfad.appnatureinfo.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hfad.appnatureinfo.model.DisasterResponseData
import com.hfad.appnatureinfo.repository.DisasterRepository
import com.hfad.appnatureinfo.repository.NetworkState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import java.lang.Exception

class DisasterViewModel(private val repository: DisasterRepository): ViewModel() {

    val disasterResponse: MutableLiveData<Response<DisasterResponseData>> = MutableLiveData()
    val networkState = MutableLiveData<NetworkState>()

    fun getDisaster() {
        networkState.postValue(NetworkState.LOADING)
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response: Response<DisasterResponseData> = repository.getDisasterResponse()
                disasterResponse.postValue(response)
                networkState.postValue(NetworkState.LOADED)
            }
            catch (e: Exception){
                Log.d("DisasterViewModel class", e.message)
            }
        }
    }

}