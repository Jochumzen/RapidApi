package com.mapifesto.datasource_trueway

import com.mapifesto.datasource_rapid.RapidDataState
import com.mapifesto.domain.RapidReverseItem
import com.mapifesto.domain.RapidReverseItems
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetRapidReverseGeocode(
    private val service: RapidService,
) {
    fun execute(
        rapidSearchMembers: RapidSearchMembers,
    ): Flow<RapidDataState<RapidReverseItem>> = flow {

        var errorMessage: String? = null

        val rapidDtoResult: RapidDto? = try {
            service.reverse(
                apiKey = rapidSearchMembers.xRapidApiKey,
                host = rapidSearchMembers.xRapidApiHost,
                location = rapidSearchMembers.location,
                language = rapidSearchMembers.language
            )
        } catch (e: Exception) {
            e.printStackTrace()
            errorMessage = e.message?: "No error message provided"
            null
        }

        if (rapidDtoResult == null) {
            emit(RapidDataState.Error("Error executing RapidInteractor. Error message: $errorMessage"))
            return@flow
        }

        val rapidReverseItem: RapidReverseItem? = Mapper.createRapidReverseItem(rapidDtoResult)

        if (rapidReverseItem == null)
            emit(RapidDataState.Error("Map to domain object failed"))
        else
            emit(RapidDataState.RapidData(rapidReverseItem))
    }




}