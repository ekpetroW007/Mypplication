package com.example.myapplication

import android.util.Log
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
    Column {
        Button(
            onClick = {
                navController.navigate("userList")
                // Попробуй
                // navController.popBackStack() вместо navController.navigate("userList")
                // И попробуй определить, в чем различие
            }
        ) {
            Text(text = "<--")
        }
        val message = remember { mutableStateOf("") }
        // Лишний текст закоментировал, но добавил вывод в Log
        //Text(message.value, fontSize = 60.sp, color = Color.Black)
        TextField(
            value = message.value,
            textStyle = TextStyle(fontSize = 60.sp, color = Color.Black),
            onValueChange = {
                // ОБЯЗАТЕЛЬНО посмотри в Logcat как меняется текст в реальном времени
                    newText ->
                message.value = newText
                Log.d("MyMessage", "newText = $newText")
            }
        )
        Button(
            onClick = {
                // Обязательно передаем параметр message
                navController.navigate("screenFour/${message.value}")
            }
        ) {
            Text(text = "Дальше")
        }
    }
}
