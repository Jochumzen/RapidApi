package com.mapifesto.datasource_rapid

import com.mapifesto.datasource_trueway.RapidDto
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*

interface RapidService {

    suspend fun reverse(
        apiKey: String,
        location: String,
    ): RapidDto

    companion object Factory {
        fun build(): RapidService {
            return RapidServiceImpl(
                httpClient = HttpClient(Android) {
                    install(JsonFeature) {
                        serializer = KotlinxSerializer(
                            kotlinx.serialization.json.Json {
                                ignoreUnknownKeys = true
                                isLenient = false
                            }
                        )
                    }
                }
            )
        }
    }
}