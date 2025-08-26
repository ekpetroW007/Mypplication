package com.example.myapplication.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ListAdder() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
    }
    val myList = remember { mutableStateListOf("") }
    val message = remember { mutableStateOf("") }

    Text(message.value, fontSize = 60.sp, color = Color.Black)
    TextField(
        value = message.value,
        textStyle = TextStyle(fontSize = 60.sp, color = Color.Black),
        onValueChange = { newText -> message.value = newText }
    )
    Button(
        onClick = { myList.add(message.value) },
        shape = RectangleShape,
        modifier = Modifier.padding(vertical = 100.dp),
        colors = ButtonDefaults.buttonColors(
            contentColor = Color(0xFFE5DFDF),
            containerColor = Color(0xFF070707)
        )
    ) {
        Text("add", fontSize = 25.sp)
    }
    LazyColumn {
        item { Text("", fontSize = 120.sp) }
        items(myList.size) { index ->
            Text(text = myList[index], fontSize = 70.sp, color = Color.White)
        }
    }
}

