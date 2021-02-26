package com.sekar.ritxbertaniminiapp.model

import com.google.gson.annotations.SerializedName

data class CreateRequest(

    @field:SerializedName("id_province")
    val idProvince: Int? = null,

    @field:SerializedName("id_city")
    val idCity: Int? = null,

    @field:SerializedName("device_address")
    val deviceAddress: String? = null,

    @field:SerializedName("serial_number")
    val serialNumber: String? = null,

    @field:SerializedName("id")
    val id: String? = null,

    @field:SerializedName("display_name")
    val displayName: String? = null,

    @field:SerializedName("region")
    val region: String? = null,

    @field:SerializedName("sub_region")
    val subRegion: String? = null,

    @field:SerializedName("sensor_name")
    val sensorName: String? = null
)
