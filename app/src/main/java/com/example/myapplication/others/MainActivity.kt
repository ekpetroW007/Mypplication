package com.example.myapplication.others

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.myapplication.presentation.DrugAdd
import com.example.myapplication.presentation.DrugInfo
import com.example.myapplication.presentation.EditingNotes
import com.example.myapplication.presentation.GardenAdd
import com.example.myapplication.presentation.MainScreen
import com.example.myapplication.presentation.Registration

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EditingNotes()
        }
    }
}

var login = "Егор Егор" // ВВОДИТ ПОЛЬЗОВАТЕЛЬ