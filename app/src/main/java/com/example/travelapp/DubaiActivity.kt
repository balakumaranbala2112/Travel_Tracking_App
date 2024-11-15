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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.travelapp.ui.theme.TravelAppTheme

class DubaiActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TravelAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    DubaiGreeting()
                }
            }
        }
    }
}

@Composable
fun DubaiGreeting() {
    Column(
        modifier = Modifier
            .background(color = Color.White)
            .padding(20.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            fontSize = 40.sp,
            color = Color(android.graphics.Color.rgb(255, 165, 0)), // Orange color
            fontFamily = FontFamily.Cursive,
            text = stringResource(id = R.string.place_dubai),
        )
        Image(
            painterResource(id = R.drawable.dubai), contentDescription = "",
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .height(200.dp)
                .scale(scaleX = 1.2F, scaleY = 1F)
        )
        Text(
            color = Color.Black,
            text = "Day 1: Arrival and Downtown Exploration\n" +
                    "Arrive in Dubai and check into your hotel\n" +
                    "Visit the Burj Khalifa and Dubai Mall\n" +
                    "Have dinner at a restaurant with views of the fountain\n" +

                    "\n" +
                    "Day 2: Desert Safari\n" +
                    "Embark on an exciting desert safari tour\n" +
                    "Enjoy dune bashing, camel rides, and a traditional barbecue dinner\n" +

                    "\n" +
                    "Day 3: Dubai Marina and Palm Jumeirah\n" +
                    "Explore the Dubai Marina and walk along the promenade\n" +
                    "Visit the iconic Palm Jumeirah and Atlantis The Palm\n" +
                    "Relax on the beach and enjoy the views of the Arabian Gulf\n" +

                    "\n" +
                    "Day 4: Cultural Exploration\n" +
                    "Visit the Dubai Museum and Al Fahidi Historical Neighborhood\n" +
                    "Take a boat ride across the Dubai Creek\n" +
                    "Explore the souks (markets) for local goods and spices\n" +

                    "\n" +
                    "Day 5: Shopping and Entertainment\n" +
                    "Spend time shopping in luxury boutiques at Mall of the Emirates\n" +
                    "Visit Ski Dubai for indoor skiing or snowboarding\n" +
                    "Watch the Dubai Fountain show at night\n" +

                    "\n" +
                    "Day 6: Abu Dhabi Day Trip\n" +
                    "Take a day trip to Abu Dhabi\n" +
                    "Visit the Sheikh Zayed Grand Mosque and the Louvre Abu Dhabi\n" +
                    "Relax at the Corniche and enjoy the beach\n" +

                    "\n" +
                    "Day 7: Farewell\n" +
                    "Relax at the hotel pool or visit the Dubai Opera\n" +
                    "Do some last-minute shopping or explore a nearby park\n" +
                    "Have a farewell dinner and prepare for departure"
        )
    }
}