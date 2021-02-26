package com.sekar.ritxbertaniminiapp.repository

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class SensorViewModel : ViewModel() {

    private val repository = SensorRepository()

    val showSuccess = repository.showSuccess
    val showFailure = repository.showFailure

    fun getSensor() {
        viewModelScope.launch { repository.getSensor() }
    }
}