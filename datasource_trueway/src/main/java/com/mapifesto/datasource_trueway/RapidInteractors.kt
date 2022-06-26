package com.mapifesto.datasource_rapid

import com.mapifesto.datasource_trueway.GetRapidReverseGeocode

class RapidInteractors(
    val getRapidReverseGeocode: GetRapidReverseGeocode
) {

    companion object Factory {
        fun build(): RapidInteractors{
            val service = RapidService.build()
            return RapidInteractors(
                getRapidReverseGeocode = GetRapidReverseGeocode(
                    service = service,
                )
            )
        }
    }

}