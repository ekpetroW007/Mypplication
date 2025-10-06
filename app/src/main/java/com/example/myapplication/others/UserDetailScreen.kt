package com.example.myapplication.others

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun UserDetailScreen(name: String, age: Int) {
    Text(
        "Детали пользователя: $name, $age"
    )
}