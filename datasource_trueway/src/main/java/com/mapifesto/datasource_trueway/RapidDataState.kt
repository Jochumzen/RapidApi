package com.mapifesto.datasource_rapid

sealed class RapidDataState<T> {

    data class Error<T>(
        val error: String
    ): RapidDataState<T>()

    data class RapidData<T>(
        val data: T
    ): RapidDataState<T>()

}
