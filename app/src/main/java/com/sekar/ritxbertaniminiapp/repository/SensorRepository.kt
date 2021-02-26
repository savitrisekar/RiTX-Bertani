package com.sekar.ritxbertaniminiapp.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.sekar.ritxbertaniminiapp.model.DataItem
import com.sekar.ritxbertaniminiapp.api.ApiClient
import com.sekar.ritxbertaniminiapp.model.CreateRequest
import com.sekar.ritxbertaniminiapp.model.UserResponse
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
            showFailure.postValue(true)
        } catch (e: SocketTimeoutException) {
            showFailure.postValue(true)
        } catch (e: Exception) {
            showFailure.postValue(true)
        }
    }

    fun createSensor(createRequest: CreateRequest) {

        apiClient.createSensor(createRequest).enqueue(object : Callback<UserResponse> {
            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                Log.d("Error insert", t.toString())
            }

            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {

                Log.d("Resposnse insert :", response?.message())
                if (response != null) {
                    if (response.isSuccessful && response.body()?.status.equals("true")) {
                        var result = response.body()?.status
                        var message = response.body()?.message

                        Log.d("Result", "response >>> $result$message")
                    }
                }
            }
        })
    }

    fun deleteSensor(id: String) {
        apiClient.deleteSensor(id).enqueue(object : Callback<Unit> {
            override fun onFailure(call: Call<Unit>, t: Throwable) {
                Log.d("Error delete", t.toString())
            }

            override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
                Log.d("Resposnse delete :", response?.message())
                if (response != null) {
                    if (response.isSuccessful) {
                        val res = response.body()

                        Log.d("Delete", "response >>> $res")
                    }
                }
            }
        })
    }

    companion object {
        val TAG = SensorRepository::class.java.simpleName
    }
}