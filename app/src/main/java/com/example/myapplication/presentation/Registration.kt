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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight.Companion.Medium
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R

@Composable
fun Registration() {
    Box(
        modifier = Modifier
            .size(600.dp, 1000.dp)
            .background(Color(0xFF2BC24B))
    ) {
//        Image(
//            bitmap = ImageBitmap.imageResource(R.drawable.greendrug),
//            contentDescription = "Препарат",
//            modifier = Modifier
//                .size(55.dp)
//                .align(Alignment.TopStart)
//                .padding(2.dp)
//        )
//
//        Image(
//            bitmap = ImageBitmap.imageResource(R.drawable.tree),
//            contentDescription = "Дерево",
//            modifier = Modifier
//                .size(70.dp)
//                .align(Alignment.TopStart)
//                .padding(start = 50.dp, top = 30.dp)
//        )
//        Image(
//            bitmap = ImageBitmap.imageResource(R.drawable.pot),
//            contentDescription = "Горшок",
//            modifier = Modifier
//                .size(85.dp)
//                .align(Alignment.TopStart)
//                .padding(start = 30.dp, top = 10.dp)
//        )
//        Image(
//            bitmap = ImageBitmap.imageResource(R.drawable.greenmygarden),
//            contentDescription = "Листок",
//            modifier = Modifier
//                .size(80.dp)
//                .align(Alignment.TopStart)
//                .padding(start = 2.dp, top = 100.dp)
//        )
//        Image(
//            bitmap = ImageBitmap.imageResource(R.drawable.regplant),
//            contentDescription = "Росток",
//            modifier = Modifier
//                .size(75.dp)
//                .align(Alignment.TopStart)
//                .padding(start = 110.dp, top = 10.dp)
//        )
//        Image(
//            bitmap = ImageBitmap.imageResource(R.drawable.drop),
//            contentDescription = "Капля",
//            modifier = Modifier
//                .size(75.dp)
//                .align(Alignment.TopStart)
//                .padding(start = 45.dp)
//        )
//    }
        Card(
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
            colors = CardDefaults.cardColors(containerColor = White),
            modifier = Modifier
                .size(height = 640.dp, width = 380.dp)
                .padding(start = 32.dp, top = 250.dp)
                .background(
                    White, shape = RoundedCornerShape(
                        topStart = 22.dp,
                        topEnd = 22.dp,
                        bottomEnd = 22.dp,
                        bottomStart = 22.dp
                    )
                )
        ) {
            Column {
                Row {
                    Text(
                        "Bookeeper",
                        modifier = Modifier
                            .padding(vertical = 30.dp, horizontal = 52.dp),
                        fontSize = 33.sp,
                        fontWeight = Medium,
                        color = Color(0xFF000000)
                    )
                    Image(
                        bitmap = ImageBitmap.imageResource(R.drawable.picofplant),
                        contentDescription = "Картинка растения в профиле",
                        modifier = Modifier
                            .padding(horizontal = 8.dp, vertical = 10.dp)
                            .size(50.dp, 80.dp)
                    )
                }
                Column {
                    val lg = remember { mutableStateOf("Логин") }
                    Text(
                        lg.value,
                        fontSize = 20.sp,
                        modifier = Modifier.padding(start = 22.dp)
                    )
                    TextField(
                        value = lg.value,
                        textStyle = TextStyle(fontSize = 20.sp),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                        onValueChange = { newText -> lg.value = newText }
                    )
                    val password = remember { mutableStateOf("Пароль") }
                    Text(
                        password.value,
                        fontSize = 20.sp,
                        modifier = Modifier.padding(start = 22.dp)
                    )
                    TextField(
                        value = password.value,
                        textStyle = TextStyle(fontSize = 20.sp),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                        onValueChange = { newText -> password.value = newText }
                    )
                }
                Button(
                    onClick = {}, modifier = Modifier
                        .padding(start = 20.dp, top = 40.dp)
                        .size(height = 70.dp, width = 310.dp)
                        .background(
                            White, shape = RoundedCornerShape(
                                topStart = 9.dp,
                            )
                        ), colors = ButtonDefaults.buttonColors(
                        contentColor = White,
                        containerColor = Color(0xFF2DBB4A),

                        )
                ) {
                    Text(
                        "Войти", fontSize = 25.sp, modifier = Modifier
                            .padding(horizontal = 22.dp)
                    )
                }
            }
        }
    }
}