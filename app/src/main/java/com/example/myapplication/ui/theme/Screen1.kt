package com.example.myapplication.ui.theme

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun ScreenChange() {
    var isSecondScreen by remember { mutableStateOf(false) }
    if (isSecondScreen == false) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                "Это экран 1"
            )
            Button(onClick = {
                isSecondScreen = true
                Log.d("isSecondScreen", isSecondScreen.toString())
            }) {
                Text("Перейти на другой экран")
            }
        }
    } else {
        val myList = remember { mutableStateListOf(1, 2, 3, 4, 5) }
        Column {
            LazyColumn {
                items(myList.size) { index ->
                    Row {
                        Text(text = myList[index].toString())
                        Button(onClick = { }) {
                            Text("кнопка ${myList[index]}")
                        }
                    }
                }
            }
            Button(onClick = {
                isSecondScreen = false
                Log.d("isSecondScreen", isSecondScreen.toString())
            }) {
                Text("Перейти на другой экран")
            }
        }
    }
}