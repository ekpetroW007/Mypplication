package com.example.myapplication.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MainScreenViewmodel : ViewModel() {
    var selectedScreen by mutableStateOf("Профиль")
    fun changeScreen(newText: String) {
        when (newText) {
            "Профиль" -> "Профиль"
            "Препараты" -> "Препараты"
            "Мои сады" -> "Мои сады"
            "Календарь" -> "Календарь"
        }
        selectedScreen = newText
    }
}