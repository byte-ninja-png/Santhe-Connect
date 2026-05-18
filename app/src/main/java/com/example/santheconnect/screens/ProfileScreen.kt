package com.example.santheconnect.screens

import androidx.compose.material3.Button
import com.example.santheconnect.ThemeViewModel
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProfileScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFF8E1))
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(30.dp))

        Card(
            shape = CircleShape,
            colors = CardDefaults.cardColors(containerColor = Color(0xFFBF360C)),
            modifier = Modifier.size(120.dp)
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "SC",
                    fontSize = 36.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Santhe Explorer",
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFBF360C)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Local food and market lover",
            fontSize = 16.sp,
            color = Color.DarkGray
        )

        Spacer(modifier = Modifier.height(30.dp))

        Text("Saved Places: 3", fontSize = 18.sp)
        Spacer(modifier = Modifier.height(12.dp))
        Text("Reviews Given: 5", fontSize = 18.sp)
        Spacer(modifier = Modifier.height(12.dp))
        Text("Favorite Category: Food", fontSize = 18.sp)
        Spacer(modifier = Modifier.height(30.dp))

        Button(
            onClick = {
                ThemeViewModel.toggleTheme()
            }
        ) {
            Text(
                text = if (ThemeViewModel.isDarkMode.value)
                    "Switch to Light Mode"
                else
                    "Switch to Dark Mode"
            )
        }
    }
}