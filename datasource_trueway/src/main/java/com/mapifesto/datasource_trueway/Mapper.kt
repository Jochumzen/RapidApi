package com.mapifesto.datasource_trueway

import com.mapifesto.domain.RapidReverseItem

object Mapper {

    fun createRapidReverseItem(dto: RapidDto): RapidReverseItem {

        var address = ""
        var postalCode = ""
        var country = ""
        var region = ""
        var area = ""
        var locality = ""
        var sublocality = ""
        var street = ""
        var house = ""
        var lat = ""
        var lon = ""
        var locationType = ""
        var type = ""

        dto.results.find {
            it.type == "street_address"
        }.apply {
            postalCode = this?.postalCode ?: ""
            country = this?.country ?: ""
            region = this?.region ?: ""
            street = this?.street ?: ""
            sublocality = this?.sublocality ?: ""

        }

        dto.results.find {
            it.type == "area"
        }.apply {
            area = this?.area ?: ""
        }

        dto.results.find {
            it.type == "locality"
        }.apply {
            locality = this?.locality ?: ""
        }

        return RapidReverseItem(
                address = address,
                postalCode = postalCode,
                country = country,
                region = region,
                area = area,
                locality = locality,
                sublocality = sublocality,
                street = street,
                house = house,
                lat = lat,
                lon = lon,
                locationType = locationType,
                type = type,
            )
    }
}