package com.example.myapplication.presentation

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.example.myapplication.Drugs

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    val selectedScreen = remember { mutableStateOf("Профиль") }
    Scaffold(
        topBar = { TopBar(selectedScreen.value) },
        bottomBar = {
            AppButtonBar(
                onClick = {
                    selectedScreen.value = "Препараты"
                }
            )
        },
    ) {  innerPadding ->
        when(selectedScreen.value) {
            "Профиль" -> Profile(innerPadding)
            "Препараты" -> Drugs(innerPadding)
            // TODO еще три экрана
        }
    }
}