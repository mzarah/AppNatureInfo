package com.hfad.appnatureinfo.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hfad.appnatureinfo.repository.EarthquakeRepository

class EarthquakeViewModelFactory (private val repository: EarthquakeRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return EarthquakeViewModel(repository) as T
    }
}