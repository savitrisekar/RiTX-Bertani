package com.sekar.ritxbertaniminiapp.repository

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sekar.ritxbertaniminiapp.model.CreateRequest
import kotlinx.coroutines.launch

class SensorViewModel : ViewModel() {

    private val repository = SensorRepository()

    val showSuccess = repository.showSuccess
    val showFailure = repository.showFailure

    fun getSensor() {
        viewModelScope.launch { repository.getSensor() }
    }

    fun createSensor(createRequest: CreateRequest) {
        viewModelScope.launch { repository.createSensor(createRequest) }
    }

    fun deleteSensor(id: String) {
        viewModelScope.launch { repository.deleteSensor(id) }
    }
}