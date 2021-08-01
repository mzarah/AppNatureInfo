package com.hfad.appnatureinfo.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hfad.appnatureinfo.repository.Repository

class EarthquakeViewModelFactory (private val repository: Repository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return EarthquakeViewModel(repository) as T
    }
}