package com.example.santheconnect.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.santheconnect.components.FoodCard
import com.example.santheconnect.data.Place

@Composable
fun HomeScreen(
    places: List<Place>,
    onPlaceClick: (Place) -> Unit
) {
    var searchText by remember { mutableStateOf("") }
    var selectedCategory by remember { mutableStateOf("All") }

    val categories = listOf("All", "Food", "Breakfast", "Market")

    val filteredPlaces = places.filter { place ->
        val matchesSearch =
            place.title.contains(searchText, ignoreCase = true) ||
                    place.description.contains(searchText, ignoreCase = true) ||
                    place.location.contains(searchText, ignoreCase = true)

        val matchesCategory =
            selectedCategory == "All" || place.category == selectedCategory

        matchesSearch && matchesCategory
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFF8E1))
            .padding(16.dp)
    ) {
        item {
            Text(
                text = "Santhe Connect",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFBF360C)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Discover Local Karnataka Food & Markets",
                fontSize = 18.sp,
                color = Color.DarkGray
            )

            Spacer(modifier = Modifier.height(20.dp))

            OutlinedTextField(
                value = searchText,
                onValueChange = { searchText = it },
                modifier = Modifier.fillMaxWidth(),
                label = { Text("Search local food or market") },
                leadingIcon = {
                    Icon(Icons.Default.Search, contentDescription = "Search")
                },
                singleLine = true
            )

            Spacer(modifier = Modifier.height(16.dp))

            LazyRow {
                items(categories.size) { index ->
                    val category = categories[index]

                    FilterChip(
                        selected = selectedCategory == category,
                        onClick = { selectedCategory = category },
                        label = { Text(category) },
                        modifier = Modifier.padding(end = 8.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))
        }

        if (filteredPlaces.isEmpty()) {
            item {
                Text(
                    text = "No results found",
                    fontSize = 18.sp,
                    color = Color.DarkGray
                )
            }
        } else {
            items(filteredPlaces.size) { index ->
                FoodCard(
                    place = filteredPlaces[index],
                    onClick = { onPlaceClick(filteredPlaces[index]) }
                )
            }
        }
    }
}