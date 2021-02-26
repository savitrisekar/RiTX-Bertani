package com.sekar.ritxbertaniminiapp.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sekar.ritxbertaniminiapp.model.DataItem
import com.sekar.ritxbertaniminiapp.api.ApiClient
import com.sekar.ritxbertaniminiapp.model.Sensors
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception
import java.net.SocketTimeoutException
import java.net.UnknownHostException

class SensorRepository {

    private val apiClient = ApiClient().api()

    val showSuccess = MutableLiveData<List<DataItem>>()
    val showFailure = MutableLiveData<Boolean>()

    suspend fun getSensor() {
        try {
            val response = apiClient.getSensor()
            Log.d(TAG, "$response")

            if (response.isSuccessful) {
                Log.d(TAG, "SUCCESS")
                Log.d(TAG, "${response.body()}")

                val body = response.body()

                body?.let {
                    showSuccess.postValue(it.data)
                }
            } else {
                Log.d(TAG, "FAILURE")
                Log.d(TAG, "${response.body()}")

                showFailure.postValue(true)
            }
        } catch (e: UnknownHostException) {
//            Log.e(TAG, e.message)
            showFailure.postValue(true)
        } catch (e: SocketTimeoutException) {
//            Log.e(TAG, e.message)
            showFailure.postValue(true)
        } catch (e: Exception) {
//            Log.e(TAG, e.message)
            showFailure.postValue(true)
        }
    }

    companion object {
        val TAG = SensorRepository::class.java.simpleName
    }
}