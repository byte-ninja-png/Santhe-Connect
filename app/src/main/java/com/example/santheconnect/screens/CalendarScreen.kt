package com.example.santheconnect.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CalendarScreen() {

    Column(

        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFF8E1))
            .padding(16.dp)

    ) {

        Text(
            text = "Santhe Calendar",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFBF360C)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Monday: Local Vegetable Market",
            fontSize = 18.sp
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "Wednesday: Handmade Products Santhe",
            fontSize = 18.sp
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "Sunday: Village Food & Weekly Market",
            fontSize = 18.sp
        )

    }

}

