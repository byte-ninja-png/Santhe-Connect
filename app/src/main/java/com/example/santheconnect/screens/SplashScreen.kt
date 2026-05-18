package com.example.santheconnect.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.santheconnect.R

@Composable
fun SplashScreen() {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFFBF360C),
                        Color(0xFFFF7043),
                        Color(0xFFFFCC80)
                    )
                )
            )
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),

            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center

        ) {

            Card(
                shape = CircleShape,

                elevation = CardDefaults.cardElevation(
                    defaultElevation = 16.dp
                )
            ) {

                Image(
                    painter = painterResource(id = R.drawable.market),

                    contentDescription = "Splash Image",

                    modifier = Modifier
                        .size(180.dp)
                        .clip(CircleShape),

                    contentScale = ContentScale.Crop
                )

            }

            Spacer(modifier = Modifier.height(30.dp))

            Text(
                text = "Santhe Connect",
                fontSize = 38.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "Discover Karnataka's Local Food & Markets",
                fontSize = 18.sp,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(50.dp))

            Text(
                text = "Powered by Local Culture",
                fontSize = 14.sp,
                color = Color.White
            )

        }

    }

}