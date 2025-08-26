package com.example.myapplication

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun ScreenReplace(navController: NavController) {
    Button(onClick = {
        navController.navigate("userList")
    }) {
        Text(text = "<--")
    }
    Column {
        val message = remember { mutableStateOf("") }
        Text(message.value, fontSize = 60.sp, color = Color.Black)
        TextField(
            value = message.value,
            textStyle = TextStyle(fontSize = 60.sp, color = Color.Black),
            onValueChange = { newText -> message.value = newText }
        )
        Button(onClick = {
            navController.navigate("screenFour")
        }) {
            Text(text = "Дальше")
        }
    }
}

