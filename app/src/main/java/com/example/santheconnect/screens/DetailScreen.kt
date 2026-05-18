package com.example.santheconnect.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.santheconnect.data.Place

@Composable
fun DetailScreen(
    place: Place,
    onBackClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFF8E1))
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = onBackClick) {
            Text("Back")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Image(
            painter = painterResource(id = place.image),
            contentDescription = place.title,
            modifier = Modifier
                .fillMaxWidth()
                .height(240.dp),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = place.title,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFBF360C)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Category: ${place.category}",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.DarkGray
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(text = place.description, fontSize = 18.sp)

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Location: ${place.location}",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Timing: ${place.timing}",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
    }
}