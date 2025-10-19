package com.example.myapplication.presentation

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.myapplication.BookeeperApp
import com.example.myapplication.viewmodel.DrugsViewmodelFactory
import com.example.myapplication.viewmodel.MainScreenViewmodel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(viewModel: MainScreenViewmodel = viewModel(), navController: NavController) {
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
            "Препараты" -> Drugs(navController)
            "Мои сады" -> MyGardens(innerPadding)
            "Календарь" -> Calendar(innerPadding)
        }
    }
}