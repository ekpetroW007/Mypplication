package com.example.myapplication.presentation

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
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

@Composable
fun Drugs(innerPadding: PaddingValues) {
    Box(
        modifier = Modifier
            .size(600.dp, 100.dp)
            .padding(innerPadding)
            .background(
                Color(0xFF09E327), shape = RoundedCornerShape(
                    topStart = 0.dp,
                    topEnd = 0.dp,
                    bottomEnd = 25.dp,
                    bottomStart = 25.dp
                )
            )
    ) {
        Text(
            "Использованные препараты",
            Modifier.padding(start = 20.dp, top = 10.dp, end = 0.dp, bottom = 0.dp),
            fontSize = 28.sp,
            color = White,
            fontWeight = Bold
        )
        Text(
            "Справочник средств",
            Modifier.padding(start = 20.dp, top = 39.dp, end = 0.dp, bottom = 0.dp),
            fontSize = 23.sp,
            color = White
        )
    }
    Card(
        border = BorderStroke(1.dp, Color(0xFF000000)),
        modifier = Modifier
            .padding(start = 25.dp, top = 140.dp, end = 0.dp, bottom = 0.dp)
            .size(height = 45.dp, width = 365.dp)
            .background(
                White, shape = RoundedCornerShape(
                    topStart = 16.dp,
                    topEnd = 0.dp,
                    bottomEnd = 0.dp,
                    bottomStart = 0.dp
                )
            )
    ) {
        Row {
            Image(
                bitmap = ImageBitmap.imageResource(R.drawable.search),
                contentDescription = "Картинка поиска",
                modifier = Modifier
                    .padding(horizontal = 22.dp)
                    .size(20.dp, 45.dp)
            )
            Text(
                "Поиск использованных препаратов...",
                modifier = Modifier
                    .padding(vertical = 14.dp),
                fontSize = 15.sp,
                color = Color(0xD2343538)
            )
        }
    }

    Card(
        modifier = Modifier
            .padding(start = 25.dp, top = 200.dp, end = 0.dp, bottom = 0.dp)
            .size(height = 130.dp, width = 365.dp)
            .background(
                White, shape = RoundedCornerShape(
                    topStart = 16.dp,
                    topEnd = 0.dp,
                    bottomEnd = 0.dp,
                    bottomStart = 0.dp
                )
            )
    ) {
        Row {
            Image(
                bitmap = ImageBitmap.imageResource(R.drawable.drug),
                contentDescription = "Картинка препарата",
                modifier = Modifier
                    .padding(horizontal = 22.dp, vertical = 25.dp)
                    .size(30.dp, 55.dp)
            )
            Column {
                Text(
                    "Бордоская смесь", modifier = Modifier
                        .padding(vertical = 25.dp),
                    fontSize = 18.sp,
                    color = Color(0xFF000000)
                )
                Text(
                    "Защита от грибковых заболеваний",
                    fontSize = 15.sp,
                    color = Color(0xFF333030)
                )
            }
        }
    }
}