package com.mapifesto.datasource_trueway

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RapidDto(

    @SerialName("results")
    val results: List<ResultsDto>

) {

    @Serializable
    data class ResultsDto (

        @SerialName("address")
        val address: String,

        @SerialName("postal_code")
        val postalCode: String? = null,

        @SerialName("country")
        val country: String,

        @SerialName("region")
        val region: String,

        @SerialName("area")
        val area: String? = null,

        @SerialName("locality")
        val locality: String? = null,

        @SerialName("sublocality")
        val sublocality: String? = null,

        @SerialName("street")
        val street: String? = null,

        @SerialName("house")
        val house: String? = null,

        @SerialName("location")
        val locationDto: LocationDto,

        @SerialName("location_type")
        val locationType: String,

        @SerialName("type")
        val type: String,
    ) {

        @Serializable
        data class LocationDto(

            @SerialName("lat")
            val lat: Double,

            @SerialName("lng")
            val lon: Double,
        )

    }
}
