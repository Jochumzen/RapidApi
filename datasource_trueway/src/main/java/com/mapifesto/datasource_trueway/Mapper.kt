package com.mapifesto.datasource_trueway

import com.mapifesto.domain.RapidReverseItem
import com.mapifesto.domain.RapidReverseItems

object Mapper {

    fun createRapidReverseItem(dto: RapidDto): RapidReverseItems? {

        return RapidReverseItems(
            items = dto.results.map {
                RapidReverseItem(
                    address = it.address,
                    postalCode = it.postalCode,
                    country = it.country,
                    region = it.region,
                    area = it.area,
                    locality = it.locality,
                    sublocality = it.sublocality,
                    street = it.street,
                    house = it.house,
                    lat = it.locationDto.lat.toString(),
                    lon = it.locationDto.lon.toString(),
                    locationType = it.locationType,
                    type = it.type,
                )
            }
        )
    }
}