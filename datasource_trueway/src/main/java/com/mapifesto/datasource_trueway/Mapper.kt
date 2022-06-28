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
        var neighborhood = ""
        var street = ""
        var house = ""
        var lat = ""
        var lon = ""
        var locationType = ""
        var type = ""


        dto.results.find {
            it.type == "poi"
        }.apply {
            when {
                address == "" -> this?.address
                postalCode == "" -> this?.postalCode
                country == "" -> this?.country
                region == "" -> this?.region
                area == "" -> this?.area
                locality == "" -> this?.locality
                neighborhood == "" -> this?.sublocality
                street == "" -> this?.street
                house == "" -> this?.house
            }
        }

        dto.results.find {
            it.type == "street_address"
        }.apply {
            when {
                address == "" -> this?.address
                postalCode == "" -> this?.postalCode
                country == "" -> this?.country
                region == "" -> this?.region
                area == "" -> this?.area
                locality == "" -> this?.locality
                neighborhood == "" -> this?.sublocality
                street == "" -> this?.street
                house == "" -> this?.house
            }
        }

        dto.results.find {
            it.type == "route"
        }.apply {
            when {
                address == "" -> this?.address
                postalCode == "" -> this?.postalCode
                country == "" -> this?.country
                region == "" -> this?.region
                area == "" -> this?.area
                locality == "" -> this?.locality
                neighborhood == "" -> this?.sublocality
                street == "" -> this?.street
                house == "" -> this?.house
            }

        }

        dto.results.find {
            it.type == "road_intersection"
        }.apply {
            when {
                address == "" -> this?.address
                postalCode == "" -> this?.postalCode
                country == "" -> this?.country
                region == "" -> this?.region
                area == "" -> this?.area
                locality == "" -> this?.locality
                neighborhood == "" -> this?.sublocality
                street == "" -> this?.street
                house == "" -> this?.house
            }

        }

        dto.results.find {
            it.type == "admin_area"
        }.apply {
            when {
                address == "" -> this?.address
                postalCode == "" -> this?.postalCode
                country == "" -> this?.country
                region == "" -> this?.region
                area == "" -> this?.area
                locality == "" -> this?.locality
                neighborhood == "" -> this?.sublocality
                street == "" -> this?.street
                house == "" -> this?.house
            }

        }

        dto.results.find {
            it.type == "country"
        }.apply {
            when {
                address == "" -> this?.address
                postalCode == "" -> this?.postalCode
                country == "" -> this?.country
                region == "" -> this?.region
                area == "" -> this?.area
                locality == "" -> this?.locality
                neighborhood == "" -> this?.sublocality
                street == "" -> this?.street
                house == "" -> this?.house
            }

        }

        dto.results.find {
            it.type == "region"
        }.apply {
            when {
                address == "" -> this?.address
                postalCode == "" -> this?.postalCode
                country == "" -> this?.country
                region == "" -> this?.region
                area == "" -> this?.area
                locality == "" -> this?.locality
                neighborhood == "" -> this?.sublocality
                street == "" -> this?.street
                house == "" -> this?.house
            }

        }

        dto.results.find {
            it.type == "area"
        }.apply {
            when {
                address == "" -> this?.address
                postalCode == "" -> this?.postalCode
                country == "" -> this?.country
                region == "" -> this?.region
                area == "" -> this?.area
                locality == "" -> this?.locality
                neighborhood == "" -> this?.sublocality
                street == "" -> this?.street
                house == "" -> this?.house
            }

        }

        dto.results.find {
            it.type == "locality"
        }.apply {
            when {
                address == "" -> this?.address
                postalCode == "" -> this?.postalCode
                country == "" -> this?.country
                region == "" -> this?.region
                area == "" -> this?.area
                locality == "" -> this?.locality
                neighborhood == "" -> this?.sublocality
                street == "" -> this?.street
                house == "" -> this?.house
            }

        }

        dto.results.find {
            it.type == "sublocality"
        }.apply {
            when {
                address == "" -> this?.address
                postalCode == "" -> this?.postalCode
                country == "" -> this?.country
                region == "" -> this?.region
                area == "" -> this?.area
                locality == "" -> this?.locality
                neighborhood == "" -> this?.sublocality
                street == "" -> this?.street
                house == "" -> this?.house
            }

        }

        dto.results.find {
            it.type == "neighborhood"
        }.apply {
            when {
                address == "" -> this?.address
                postalCode == "" -> this?.postalCode
                country == "" -> this?.country
                region == "" -> this?.region
                area == "" -> this?.area
                locality == "" -> this?.locality
                neighborhood == "" -> this?.sublocality
                street == "" -> this?.street
                house == "" -> this?.house
            }

        }

        dto.results.find {
            it.type == "building"
        }.apply {
            when {
                address == "" -> this?.address
                postalCode == "" -> this?.postalCode
                country == "" -> this?.country
                region == "" -> this?.region
                area == "" -> this?.area
                locality == "" -> this?.locality
                neighborhood == "" -> this?.sublocality
                street == "" -> this?.street
                house == "" -> this?.house
            }

        }

        dto.results.find {
            it.type == "postal_code"
        }.apply {
            when {
                address == "" -> this?.address
                postalCode == "" -> this?.postalCode
                country == "" -> this?.country
                region == "" -> this?.region
                area == "" -> this?.area
                locality == "" -> this?.locality
                neighborhood == "" -> this?.sublocality
                street == "" -> this?.street
                house == "" -> this?.house
            }
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