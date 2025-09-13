package com.example.myapplication

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.viewmodel.TextInputViewModel

@Composable
fun TextInputScreen(viewModel: TextInputViewModel = viewModel()) {
    var message2 = viewModel.message.value
    Column {
        Text("Hello, $message2", fontSize = 28.sp)
        TextField(
            value = message2,
            textStyle = TextStyle(fontSize = 25.sp),
            onValueChange = { newText -> viewModel.updateText(newText) }
        )
        Button(onClick = { message2 = "" }) {
            Text("clear")
        }

    }

//    val counter = viewModel.count.value
//    Column {
//        Button(onClick = { viewModel.increment() }) {
//            Text("+")
//        }
//        Text("$counter")
//    }
}