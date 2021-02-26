package com.sekar.ritxbertaniminiapp.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Sensor(

	@field:SerializedName("code")
	val code: Int? = null,

	@field:SerializedName("data")
	val data: List<DataItem>? = null,

	@field:SerializedName("count")
	val count: Int? = null,

	@field:SerializedName("status")
	val status: String? = null
) : Parcelable

@Parcelize
data class Province(

	@field:SerializedName("area_code")
	val areaCode: String? = null,

	@field:SerializedName("province_name")
	val provinceName: String? = null
) : Parcelable

@Parcelize
data class City(

	@field:SerializedName("area_code")
	val areaCode: String? = null,

	@field:SerializedName("name")
	val name: String? = null
) : Parcelable

@Parcelize
data class DataItem(

	@field:SerializedName("id_province")
	val idProvince: Int? = null,

	@field:SerializedName("id_city")
	val idCity: Int? = null,

	@field:SerializedName("province")
	val province: Province? = null,

	@field:SerializedName("city")
	val city: City? = null,

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
) : Parcelable {
	constructor(
		idProvince: String,
		idCity: String,
		province: String,
		city: String,
		deviceAddress: String?,
		serialNumber: String?,
		id: String?,
		displayName: String?
	) : this(
	)
}


