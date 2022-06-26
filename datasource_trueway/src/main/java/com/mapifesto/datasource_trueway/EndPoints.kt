package com.mapifesto.datasource_trueway

object EndPoints {

    private const val RAPID_URL = "https://trueway-geocoding.p.rapidapi.com"
    private const val REVERSE_API = "/ReverseGeocode"
    const val REVERSE = "$RAPID_URL$REVERSE_API"

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
