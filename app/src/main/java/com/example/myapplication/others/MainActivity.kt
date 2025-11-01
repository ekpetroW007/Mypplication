package com.example.myapplication.others

import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.presentation.MainScreen
import com.example.myapplication.presentation.navigation.AppNavigation
import com.example.myapplication.viewmodel.MainScreenViewmodel

//private lateinit var sharedPrefs: SharedPreferences
//val editor = sharedPrefs.edit()

// На экране входа

//@Composable
//fun OnLoginSuccess() {
//    editor.putString("user_login", "testuser")
//    editor.putBoolean("is_logged_in", true)
//    editor.apply() // или commit()
//
//
//}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppNavigation()
//            if (sharedPrefs.getBoolean("is_logged_in", false)) {
//                MainScreen(viewModel(), rememberNavController())
//            } else {
//                OnLoginSuccess()
//            }
        }
    }
}

var login = "Егор Егор" // ВВОДИТ ПОЛЬЗОВАТЕЛЬ