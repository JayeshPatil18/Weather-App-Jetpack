package com.apps.weatherapp

import android.graphics.drawable.Icon
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.apps.weatherapp.api.NetworkResponse
import com.apps.weatherapp.api.WeatherModel
import com.apps.weatherapp.ui.theme.Black40
import com.apps.weatherapp.ui.theme.BlackGrey40
import com.apps.weatherapp.ui.theme.Blue40
import com.apps.weatherapp.ui.theme.White40

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WeatherPage(viewModel: WeatherViewModel) {

    var city by remember {
        mutableStateOf("")
    }

    val weatherResult = viewModel.weatherResult.observeAsState()
    val keyboardController = LocalSoftwareKeyboardController.current

    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Spacer(modifier = Modifier.height(30.dp))
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp),

            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ){
            TextField(
                value = city,
                onValueChange = {
                    city = it
                },
                placeholder = {
                    Text(text = "Search for Location", style = TextStyle(color = Color.Gray, fontSize = 16.sp))
                },
                textStyle = TextStyle(color = White40, fontSize = 18.sp),
                modifier = Modifier
                    .background(Color.LightGray, shape = RoundedCornerShape(10.dp)),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = BlackGrey40,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
//                    cursorColor = Blue40
                ),
                shape = RoundedCornerShape(10.dp),
                singleLine = true,
            )
            Box(
                modifier = Modifier
                    .padding(start = 5.dp)
                    .background(
                        shape = RoundedCornerShape(10.dp),
                        color = BlackGrey40
                    ),

                contentAlignment = Alignment.Center,
            ) {
                IconButton(
                    onClick = {
                        viewModel.getData(city)
                        keyboardController?.hide()
                    }
                ) {
                    Icon(
                        modifier = Modifier.size(24.dp),
                        imageVector = Icons.Default.Search, tint = White40, contentDescription = "Search")
                }
            }
        }

        Spacer(modifier = Modifier.height(40.dp))

        when(val result = weatherResult.value){
            is NetworkResponse.Error -> {
                Text(text = result.message, style = TextStyle(color = White40))
            }
            NetworkResponse.Loading -> {
                CircularProgressIndicator()
            }
            is NetworkResponse.Success -> {
                WeatherDetails(data = result.data)
            }
            null -> {
                Text(text = "Search", style = TextStyle(color = White40), fontSize = 20.sp, modifier = Modifier.padding(top = 200.dp), textAlign = TextAlign.Center)
            }
        }
    }
}

@Composable
fun WeatherDetails(data: WeatherModel){
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp, end = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.Bottom
        ) {
            Icon(
                imageVector = Icons.Default.LocationOn,
                tint = White40,
                contentDescription = "Location icon",
                modifier = Modifier.size(38.dp)
            )
            Spacer(modifier = Modifier.width(2.dp))
            Text(text = data.location.name, fontSize = 30.sp, color = White40)
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = data.location.country, fontSize = 16.sp, color = Color.Gray, modifier = Modifier.padding(bottom = 4.dp))
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "${data.current.temp_c} ° c",
            fontSize = 56.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            color = White40
        )

        AsyncImage(
            modifier = Modifier.size(140.dp),
            model = "https:${data.current.condition.icon}".replace("64x64", "128x128"),
            contentDescription = "Condition Icon"
        )

        Text(
            text = data.current.condition.text,
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(20.dp))

        Card (){
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = BlackGrey40)
                    .padding(start = 10.dp, end = 10.dp),
            ) {
                Row (
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ){
                    WeatherKeyVal(key = "Humidity", value = data.current.humidity)
                    WeatherKeyVal(key = "Wind Speed", value = data.current.wind_kph+" km/h")
                }
                Row (
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ){
                    WeatherKeyVal(key = "UV", value = data.current.uv)
                    WeatherKeyVal(key = "Participation", value = data.current.precip_mm+" ,,")
                }
                Row (
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ){
                    WeatherKeyVal(key = "Local Time", value = data.location.localtime.split(" ")[1])
                    WeatherKeyVal(key = "Local Date", value = data.location.localtime.split(" ")[0])
                }
            }
        }
    }
}

@Composable
fun WeatherKeyVal(key: String, value: String) {
    Column(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = value, color = White40, fontSize = 20.sp)
        Text(text = key, color = Color.Gray, fontSize = 16.sp)
        Spacer(modifier = Modifier.height(10.dp))
    }
}
