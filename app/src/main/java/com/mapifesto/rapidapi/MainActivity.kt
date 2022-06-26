package com.mapifesto.rapidapi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.mapifesto.datasource_rapid.RapidDataState
import com.mapifesto.datasource_trueway.RapidIntermediary
import com.mapifesto.datasource_trueway.RapidSearchMembers
import com.mapifesto.domain.OrsSearchItems
import com.mapifesto.domain.RapidReverseItems
import com.mapifesto.rapidapi.ui.theme.RapidApiTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var rapidIntermediary: RapidIntermediary

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RapidApiTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Compose(rapidIntermediary = rapidIntermediary)
                }
            }
        }
    }
}

@Composable
fun Compose(
    rapidIntermediary: RapidIntermediary
) {

    // CHECK BELOW FOR HOW THE API IS SUPPOSED TO LOOK LIKE

    val apiKey = "6132aa3549mshbf538dd63606747p15f191jsne5c459961d7d"
    var showWhat by remember {mutableStateOf("")}
    var locationString by remember { mutableStateOf("") }
    var errorMsg by remember {mutableStateOf("")}
    var rapidReverseItems by remember { mutableStateOf<RapidReverseItems?>(null) }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        Column() {

            Row() {
                OutlinedTextField(
                    value = locationString,
                    onValueChange = {
                        locationString = it
                    }
                )
            }

            Row {
                Button(
                    onClick = {
                        showWhat = ""
                        errorMsg = ""

                        rapidIntermediary.reverseSearch(
                            rapidSearchMembers = RapidSearchMembers(
                                rapidApiApp = "default-application_6450676",
                                requestUrl = "rapidapi.com",
                                xRapidApiKey = apiKey,
                                xRapidApiHost = "trueway-geocoding.p.rapidapi.com",
                                location = locationString,
                                language = "en"
                            )
                        ) {
                            when (it) {
                                is RapidDataState.Error -> errorMsg = it.error
                                is RapidDataState.RapidData -> {
                                    showWhat = "Reverse completed"
                                    rapidReverseItems = it.data
                                }
                            }
                        }
                    }
                ) {
                    Text("Reverse geocode")
                }
            }

            if(errorMsg != "") Text("Error: $errorMsg") else {

                when (showWhat) {
                    "Reverse completed" -> {
                        LazyColumn(
                            state = rememberLazyListState()
                        ) {
                            items(rapidReverseItems!!.items.map {
                                "${it.address}, "
                                "${it.postalCode} " +
                                        "${it.country}, " +
                                        it.region + it.area + it.locality + it.sublocality + it.street + it.house + locationString + it.locationType + it.type
                            }) {
                                Text(it)
                            }
                        }
                    }
                }
            }
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
