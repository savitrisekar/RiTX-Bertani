package com.sekar.ritxbertaniminiapp.model

data class Sensors(
    val id: String,
    val display_name: String,
    val serial_number: String
) {
    constructor() : this("", "", "")
}