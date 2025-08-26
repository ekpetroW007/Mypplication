package com.example.myapplication.open

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CloseContent() {
    var myString by remember { mutableStateOf("Зачем?") }
    var myString2 by remember { mutableStateOf("Почему?") }
    var myString3 by remember { mutableStateOf("Для чего?") }
    Row {
        Box(
            modifier = Modifier
                .height(150.dp)
                .width(100.dp)
                .combinedClickable(
                    onDoubleClick = { myString2 = "Почему?" },
                    onClick = { myString2 = "Потому!" },
                )
        ) {
            Text(
                myString2,
                modifier = Modifier.padding(16.dp)
            )
        }

        Box(
            modifier = Modifier
                .height(150.dp)
                .width(100.dp)
                .combinedClickable(
                    onDoubleClick = { myString = "Зачем?" },
                    onClick = { myString = "Затем!" },
                )
        ) {
            Text(
                myString,
                modifier = Modifier.padding(16.dp)
            )
        }
        Box(
            modifier = Modifier
                .height(150.dp)
                .width(100.dp)
                .combinedClickable(
                    onDoubleClick = { myString3 = "Для чего?" },
                    onClick = { myString3 = "Для того!" },
                )
        ) {
            Text(
                myString3,
                modifier = Modifier.padding(16.dp)
            )
        }


    }
}