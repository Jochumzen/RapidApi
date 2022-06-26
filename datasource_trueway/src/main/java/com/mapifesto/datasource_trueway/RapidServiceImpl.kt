package com.mapifesto.datasource_trueway

import com.mapifesto.datasource_trueway.EndPoints.REVERSE
import io.ktor.client.*
import io.ktor.client.request.*

class RapidServiceImpl(
    private val httpClient: HttpClient,
): RapidService {

    override suspend fun reverse(
        apiKey: String,
        host: String,
        location: String,
        language: String,
    ): RapidDto {

        return httpClient.get {
            url("$REVERSE")
            header(key = "X-RapidAPI-Key", value = apiKey)
            header(key = "X-RapidAPI-Host", value = host)
            parameter(key = "location", value = location)
            parameter(key = "language", value = language)

        }

    }
}

/*
const axios = require("axios");

const options = {
    method: 'GET',
    url: 'https://trueway-geocoding.p.rapidapi.com/ReverseGeocode',
    params: {location: '37.7879493,-122.3961974', language: 'en'},
    headers: {
        'X-RapidAPI-Key': '6132aa3549mshbf538dd63606747p15f191jsne5c459961d7d',
        'X-RapidAPI-Host': 'trueway-geocoding.p.rapidapi.com'
    }
};

axios.request(options).then(function (response) {
    console.log(response.data);
}).catch(function (error) {
    console.error(error);
});*/