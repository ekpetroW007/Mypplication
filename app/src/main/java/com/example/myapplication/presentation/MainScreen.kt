package com.example.myapplication.presentation

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.viewmodel.MainScreenViewmodel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(viewModel: MainScreenViewmodel = viewModel()) {
    val selectedScreen = viewModel.selectedScreen
    Scaffold(
        topBar = { TopBar(selectedScreen) },
        bottomBar = {
            AppButtonBar(
                onClick = {input ->
                    viewModel.changeScreen(input)
                }
            )
        },
    ) { innerPadding ->
        when (selectedScreen) {
            "Профиль" -> Profile(innerPadding)
            "Препараты" -> Drugs(innerPadding)
            "Мои сады" -> MyGardens(innerPadding)
            "Календарь" -> Calendar(innerPadding)
        }
    }
}