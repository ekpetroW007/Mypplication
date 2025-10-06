package com.example.myapplication.others

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun ScreenFive(navController: NavController, message: String?) {
    Text(text = "$message $message")
}