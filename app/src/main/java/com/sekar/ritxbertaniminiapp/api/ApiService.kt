package com.sekar.ritxbertaniminiapp.api

import com.sekar.ritxbertaniminiapp.model.*
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    @GET("api/v1/sensors")
    suspend fun getSensor(): Response<Sensor>

    @POST("api/v1/sensors")
    fun createSensor(@Body createRequest: CreateRequest): Call<UserResponse>

    @DELETE("api/v1/sensors/{id}")
    fun deleteSensor(
        @Path("id") id: String
    ): Call<Unit>
}
