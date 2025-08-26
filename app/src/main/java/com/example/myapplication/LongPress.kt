package com.example.myapplication


import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun LongPress() {
    val myItems = remember { mutableStateListOf(3, 2, 3, 4) }
    LazyColumn {
        items(items = myItems) { item ->
            Element(item.toString())
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Element(stroka: String) {
    var myString by remember {mutableStateOf(stroka) }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .combinedClickable(
                onLongClick = {myString = "длинное нажатие"},
                onClick = {myString = "короткое нажатие"}
            )
    ) {
        Text(
            myString,
            modifier = Modifier.padding(16.dp)
        )
    }
}