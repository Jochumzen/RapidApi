package com.mapifesto.datasource_rapid

import com.mapifesto.datasource_trueway.EndPoints.REVERSE
import com.mapifesto.datasource_trueway.RapidDto
import io.ktor.client.*
import io.ktor.client.request.*

class RapidServiceImpl(
    private val httpClient: HttpClient,
): RapidService {

    override suspend fun reverse(
        apiKey: String,
        location: String
    ): RapidDto {

        return httpClient.get {
            url("$REVERSE")
            parameter(key = "X-RapidAPI-Key", value = apiKey)
            parameter(key = "location", value = location)

        }

    }


}