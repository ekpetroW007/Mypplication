package com.example.myapplication.presentation

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    val selectedScreen = remember { mutableStateOf("Мои сады") }
    Scaffold(
        topBar = { TopBar(selectedScreen.value) },
        bottomBar = {
            AppButtonBar(
                onClick = {
                    MainScreenViewmodel().changeScreen(selectedScreen.value)
                }
            )
        },
    ) { innerPadding ->
        when (selectedScreen.value) {
            "Профиль" -> Profile(innerPadding)
            "Препараты" -> Drugs(innerPadding)
            "Мои сады" -> MyGardens(innerPadding)
            "Календарь" -> Calendar(innerPadding)
        }
    }
}