package com.example.myapplication.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R
import com.example.myapplication.email

@Composable
fun TopBar(topBarText: String) {
    Box(
        modifier = Modifier
            .size(600.dp, 100.dp)
            .background(
                Color(0xFF09E327), shape = RoundedCornerShape(
                    topStart = 0.dp,
                    topEnd = 0.dp,
                    bottomEnd = 25.dp,
                    bottomStart = 25.dp
                )
            )
    ) {
        Row {
            // TODO ПО ТАКОМУ ЖЕ ПРИНЦИПУ, КАК С ТОПБАРТЕКСТ (ДОБАВИТЬ ИФ)
            when (topBarText) {
                "Профиль" -> {
                    Image(
                        bitmap = ImageBitmap.imageResource(R.drawable.profile),
                        contentDescription = "Профиль", // TODO ПО ТАКОМУ ЖЕ ПРИНЦИПУ, КАК С ТОПБАРТЕКСТ
                        modifier = Modifier
                            .padding(horizontal = 10.dp, vertical = 20.dp)
                            .size(80.dp, 110.dp)
                    )
                }

                "Календарь" -> {
                    Image(
                        bitmap = ImageBitmap.imageResource(R.drawable.calendar),
                        contentDescription = "Календарь", // TODO ПО ТАКОМУ ЖЕ ПРИНЦИПУ, КАК С ТОПБАРТЕКСТ
                        modifier = Modifier
                            .padding(horizontal = 10.dp, vertical = 20.dp)
                            .size(80.dp, 110.dp)
                    )
                }

                "Мои сады" -> {
                    Image(
                        bitmap = ImageBitmap.imageResource(R.drawable.mygardens),
                        contentDescription = "Мои сады", // TODO ПО ТАКОМУ ЖЕ ПРИНЦИПУ, КАК С ТОПБАРТЕКСТ
                        modifier = Modifier
                            .padding(horizontal = 10.dp, vertical = 20.dp)
                            .size(80.dp, 110.dp)
                    )
                }

                "Препараты" -> {
                    Image(
                        bitmap = ImageBitmap.imageResource(R.drawable.drug),
                        contentDescription = "Препараты", // TODO ПО ТАКОМУ ЖЕ ПРИНЦИПУ, КАК С ТОПБАРТЕКСТ
                        modifier = Modifier
                            .padding(horizontal = 10.dp, vertical = 20.dp)
                            .size(80.dp, 110.dp)
                    )
                }
            }
            Column {
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    topBarText,
                    fontSize = 35.sp,
                    color = White,
                    fontWeight = Bold
                )

                Text(
                    email, // TODO ПО ТАКОМУ ЖЕ ПРИНЦИПУ, КАК С ТОПБАРТЕКСТ (ДОБАВИТЬ ИФ)
                    fontSize = 20.sp,
                    color = White
                )

            }
        }
    }
}