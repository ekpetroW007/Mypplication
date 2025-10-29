package com.example.myapplication.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R

@Composable
fun PlantAdd() {
    Box(
        modifier = Modifier
            .size(600.dp, 100.dp)
            .background(
                Color(0xFF40BE54), shape = RoundedCornerShape(
                    bottomEnd = 25.dp,
                    bottomStart = 25.dp
                )
            )
    ) {
        Row {
            Image(
                bitmap = ImageBitmap.imageResource(R.drawable.arrow),
                contentDescription = "Стрелка",
                modifier = Modifier
                    .padding(start = 22.dp, top = 28.dp)
                    .size(35.dp, 40.dp)
            )
            Image(
                bitmap = ImageBitmap.imageResource(R.drawable.threefullstops),
                contentDescription = "Три точки", // в трех точках будет "удалить карточку"
                modifier = Modifier
                    .padding(start = 300.dp, top = 28.dp)
                    .size(35.dp, 40.dp)
            )
        }
    }
    Column {
        Text(
            "Название растения:",
            modifier = Modifier.padding(top = 120.dp, start = 20.dp),
            fontSize = 20.sp
        )
        val plantName = remember { mutableStateOf("") }
        Text(plantName.value, fontSize = 20.sp, modifier = Modifier.padding(top = 5.dp, start = 20.dp))
        TextField(
            value = plantName.value,
            textStyle = TextStyle(fontSize = 20.sp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
            onValueChange = { newText -> plantName.value = newText }
        )
        Text(
            "Препарат:",
            modifier = Modifier.padding(top = 20.dp, start = 20.dp),
            fontSize = 20.sp
        )
        val drug = remember { mutableStateOf("") }
        Text(drug.value, fontSize = 20.sp, modifier = Modifier.padding(top = 5.dp, start = 20.dp))
        TextField(
            value = drug.value,
            textStyle = TextStyle(fontSize = 20.sp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
            onValueChange = { newText -> drug.value = newText }
        )
        Text(
            "Задача:",
            modifier = Modifier.padding(top = 20.dp, start = 20.dp),
            fontSize = 20.sp
        )
        val task = remember { mutableStateOf("") }
        Text(task.value, fontSize = 20.sp, modifier = Modifier.padding(top = 5.dp, start = 20.dp))
        TextField(
            value = task.value,
            textStyle = TextStyle(fontSize = 20.sp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
            onValueChange = { newText -> task.value = newText }
        )
        Text(
            "Название сада:",
            modifier = Modifier.padding(top = 20.dp, start = 20.dp),
            fontSize = 20.sp
        )
        val gardenName = remember { mutableStateOf("") }
        Text(gardenName.value, fontSize = 20.sp, modifier = Modifier.padding(top = 5.dp, start = 20.dp))
        TextField(
            value = gardenName.value,
            textStyle = TextStyle(fontSize = 20.sp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
            onValueChange = { newText -> gardenName.value = newText }
        )
        Text(
            "Интервал полива:",
            modifier = Modifier.padding(top = 20.dp, start = 20.dp),
            fontSize = 20.sp
        )
        val period = remember { mutableStateOf("") }
        Text(period.value, fontSize = 20.sp, modifier = Modifier.padding(top = 5.dp, start = 20.dp))
        TextField(
            value = period.value,
            textStyle = TextStyle(fontSize = 20.sp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
            onValueChange = { newText -> period.value = newText }
        )
        Text(
            "Фото:",
            modifier = Modifier.padding(top = 20.dp, start = 20.dp),
            fontSize = 20.sp
        )
        val plantPhoto = remember { mutableStateOf("") }
        Text(plantPhoto.value, fontSize = 20.sp, modifier = Modifier.padding(top = 5.dp, start = 20.dp))
        TextField(
            value = plantPhoto.value,
            textStyle = TextStyle(fontSize = 20.sp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
            onValueChange = { newText -> plantPhoto.value = newText }
        )
    }
}