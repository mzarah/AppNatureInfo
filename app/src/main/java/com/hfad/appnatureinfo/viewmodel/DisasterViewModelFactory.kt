package com.hfad.appnatureinfo.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hfad.appnatureinfo.repository.DisasterRepository

class DisasterViewModelFactory (private val repository: DisasterRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return DisasterViewModel(repository) as T
    }
}