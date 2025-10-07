package com.example.myapplication.others

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.myapplication.presentation.DrugAdd
import com.example.myapplication.presentation.DrugInfo
import com.example.myapplication.presentation.GardenAdd
import com.example.myapplication.presentation.MainScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DrugInfo()
        }
    }
}

var login = "Егор Егор" // ВВОДИТ ПОЛЬЗОВАТЕЛЬ