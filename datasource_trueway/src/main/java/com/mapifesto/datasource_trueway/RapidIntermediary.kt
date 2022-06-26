package com.mapifesto.datasource_trueway

import com.mapifesto.datasource_rapid.RapidDataState
import com.mapifesto.datasource_rapid.RapidInteractors
import com.mapifesto.domain.RapidReverseItems
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

data class RapidSearchMembers(
    val rapidApiApp: String,
    val requestUrl: String,
    val xRapidApiKey: String,
    val xRapidApiHost: String,
    val location: String,
    val language: String,
)

interface RapidIntermediary {

    fun reverseSearch(
        rapidSearchMembers: RapidSearchMembers,
        callback: (RapidDataState<RapidReverseItems>) -> Unit
    )

}

class RapidIntermediaryImpl: RapidIntermediary {

    override fun reverseSearch(
        rapidSearchMembers: RapidSearchMembers,
        callback: (RapidDataState<RapidReverseItems>) -> Unit
    ) {

        val getRapidReverseGeocode = RapidInteractors.build().getRapidReverseGeocode
        getRapidReverseGeocode.execute(
            rapidSearchMembers = rapidSearchMembers
        ).onEach { dataState ->

            callback(dataState)
        }.launchIn(CoroutineScope(Dispatchers.Main))

    }
}

class RapidIntermediaryMockup: RapidIntermediary {
    override fun reverseSearch(
        rapidSearchMembers: RapidSearchMembers,
        callback: (RapidDataState<RapidReverseItems>) -> Unit
    ) {
        TODO("Not yet implemented")
    }

}