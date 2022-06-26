package com.mapifesto.datasource_trueway

import com.mapifesto.datasource_rapid.RapidServiceImpl
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*

interface RapidService {

    suspend fun reverse(
        apiKey: String,
        host: String,
        location: String,
        language: String,
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