package com.example.santheconnect

import androidx.compose.material.icons.filled.Add
import com.example.santheconnect.screens.AddPlaceScreen
import androidx.compose.material.icons.filled.Person
import com.example.santheconnect.screens.ProfileScreen
import androidx.compose.runtime.LaunchedEffect
import com.example.santheconnect.screens.SplashScreen
import kotlinx.coroutines.delay
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.padding
import com.example.santheconnect.data.Place
import com.example.santheconnect.screens.CalendarScreen
import com.example.santheconnect.screens.DetailScreen
import com.example.santheconnect.screens.HomeScreen
import com.example.santheconnect.screens.ReviewScreen
import com.example.santheconnect.ui.theme.SantheConnectTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            SantheConnectTheme(
                darkTheme = ThemeViewModel.isDarkMode.value
            ) {
                SantheApp()
            }
        }
    }
}

@Composable
fun SantheApp() {
    var showSplash by remember { mutableStateOf(true) }

    LaunchedEffect(Unit) {
        delay(2500)
        showSplash = false
    }

    if (showSplash) {
        SplashScreen()
        return
    }


    var selectedTab by remember { mutableIntStateOf(0) }
    var selectedPlace by remember { mutableStateOf<Place?>(null) }

    val places = listOf(
        Place(
            "Jolada Rotti",
            "Traditional North Karnataka food served with curry and chutney.",
            R.drawable.jolada_rotti,
            "Local Khana-Vali",
            "12:00 PM - 3:00 PM",
            "Food"
        ),
        Place(
            "Thatte Idli",
            "Soft Karnataka breakfast served with chutney and sambar.",
            R.drawable.idli,
            "Morning Eatery",
            "7:00 AM - 11:00 AM",
            "Breakfast"
        ),
        Place(
            "Village Santhe",
            "Weekly local market for vegetables and local products.",
            R.drawable.market,
            "Near Bus Stand",
            "Every Sunday, 8:00 AM - 2:00 PM",
            "Market"
        )
    )

    Scaffold(
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    selected = selectedTab == 0,
                    onClick = {
                        selectedTab = 0
                        selectedPlace = null
                    },
                    icon = {
                        Icon(Icons.Default.Home, contentDescription = "Home")
                    },
                    label = {
                        Text("Home")
                    }
                )
                NavigationBarItem(
                    selected = selectedTab == 4,
                    onClick = {
                        selectedTab = 4
                        selectedPlace = null
                    },
                    icon = {
                        Icon(Icons.Default.Add, contentDescription = "Add")
                    },
                    label = {
                        Text("Add")
                    }
                )

                NavigationBarItem(
                    selected = selectedTab == 1,
                    onClick = {
                        selectedTab = 1
                        selectedPlace = null
                    },
                    icon = {
                        Icon(Icons.Default.DateRange, contentDescription = "Calendar")
                    },
                    label = {
                        Text("Calendar")
                    }
                )
                NavigationBarItem(
                    selected = selectedTab == 3,
                    onClick = {
                        selectedTab = 3
                        selectedPlace = null
                    },
                    icon = {
                        Icon(Icons.Default.Person, contentDescription = "Profile")
                    },
                    label = {
                        Text("Profile")
                    }
                )

                NavigationBarItem(
                    selected = selectedTab == 2,
                    onClick = {
                        selectedTab = 2
                        selectedPlace = null
                    },
                    icon = {
                        Icon(Icons.Default.Star, contentDescription = "Reviews")
                    },
                    label = {
                        Text("Reviews")
                    }
                )
            }
        }
    ) { innerPadding ->

        Surface(
            modifier = Modifier.padding(innerPadding)
        ) {
            if (selectedPlace != null) {
                DetailScreen(
                    place = selectedPlace!!,
                    onBackClick = {
                        selectedPlace = null
                    }
                )
            } else {
                when (selectedTab) {
                    0 -> HomeScreen(
                        places = places,
                        onPlaceClick = {
                            selectedPlace = it
                        }
                    )

                    1 -> CalendarScreen()

                    2 -> ReviewScreen()

                    3 -> ProfileScreen()
                    4 -> AddPlaceScreen()
                }
            }
        }
    }
}