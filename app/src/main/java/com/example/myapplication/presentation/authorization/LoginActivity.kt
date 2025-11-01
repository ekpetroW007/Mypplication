package com.example.myapplication.presentation.authorization

import android.content.SharedPreferences


class LoginActivity {
    private lateinit var sharedPrefs: SharedPreferences
    val editor = sharedPrefs.edit()

    fun onLoginSuccess() {
        editor.putString("user_login", "login")
        editor.putBoolean("is_logged_in", true)
        editor.apply()

        // Перенаправление на главный экран
    }
}