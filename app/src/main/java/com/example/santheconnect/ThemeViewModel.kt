package com.example.santheconnect

import androidx.compose.runtime.mutableStateOf

object ThemeViewModel {

    val isDarkMode = mutableStateOf(false)

    fun toggleTheme() {
        isDarkMode.value = !isDarkMode.value
    }
}