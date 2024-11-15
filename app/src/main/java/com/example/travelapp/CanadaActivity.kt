package com.example.travelapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.travelapp.ui.theme.TravelAppTheme

class CanadaActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TravelAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    CanadaGreeting()
                }
            }
        }
    }
}

@Composable
fun CanadaGreeting() {
    Column(
        modifier = Modifier.background(color = Color.White)
            .padding(20.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            fontSize = 40.sp,
            color = Color(android.graphics.Color.rgb(60, 80, 200)),
            fontFamily = FontFamily.Cursive,
            text = stringResource(id = R.string.place_canada),
        )
        Image(
            painterResource(id = R.drawable.canada), contentDescription = "",
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .height(200.dp)
                .scale(scaleX = 1.2F, scaleY = 1F)
        )
        Text(
            color = Color.Black,
            text = "Day 1: Arrival and City Tour\n" +
                    "Arrive in Toronto and check into your hotel\n" +
                    "Explore downtown Toronto, including the CN Tower and waterfront\n" +
                    "Have dinner at a local restaurant\n" +

                    "\n" +
                    "Day 2: Niagara Falls Day Trip\n" +
                    "Take a day trip to Niagara Falls and experience the breathtaking views\n" +
                    "Visit Niagara-on-the-Lake, a charming town nearby\n" +
                    "Return to Toronto for dinner\n" +

                    "\n" +
                    "Day 3: Cultural Sites and Museum\n" +
                    "Visit the Royal Ontario Museum and explore diverse exhibits\n" +
                    "Explore the Distillery District, known for its historic buildings and art galleries\n" +
                    "Enjoy dinner in the Distillery District\n" +

                    "\n" +
                    "Day 4: Quebec City - History and Architecture\n" +
                    "Fly to Quebec City and check into your accommodation\n" +
                    "Walk through Old Quebec and visit Château Frontenac\n" +
                    "Enjoy dinner in a cozy bistro\n" +

                    "\n" +
                    "Day 5: Nature and Outdoor Activities\n" +
                    "Explore Montmorency Falls, located just outside Quebec City\n" +
                    "Take a scenic drive along the St. Lawrence River\n" +
                    "Return to Quebec City for dinner\n" +

                    "\n" +
                    "Day 6: Montreal's Cultural Hub\n" +
                    "Travel to Montreal and check into your accommodation\n" +
                    "Visit Notre-Dame Basilica and explore Old Montreal\n" +
                    "Have dinner at a famous Montreal eatery\n" +

                    "\n" +
                    "Day 7: Farewell\n" +
                    "Take a stroll through Mount Royal Park\n" +
                    "Visit the Montreal Museum of Fine Arts\n" +
                    "Have a farewell dinner and prepare for departure"
        )
    }
}
