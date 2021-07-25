package com.hfad.appnatureinfo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hfad.appnatureinfo.model.ResponseData
import com.hfad.appnatureinfo.repository.Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import java.lang.Exception

class EarthquakeViewModel(private val repository: Repository): ViewModel() {

    val earthquakeResponse: MutableLiveData<Response<ResponseData>> = MutableLiveData()

    fun getEarthquake() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response: Response<ResponseData> = repository.getEarthquakeResponse()
                earthquakeResponse.postValue(response)
            }
            catch (e: Exception){
                Log.d("PostViewModel class", e.message)
            }
        }
    }

}