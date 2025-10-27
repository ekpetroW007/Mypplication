package com.example.myapplication.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.myapplication.R

@Composable
fun DrugInfo(navController: NavController) {
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
            Text(
                "Препарат",
                modifier = Modifier.padding(start = 20.dp, top = 33.dp),
                fontSize = 33.sp,
                fontWeight = Bold,
                color = White
            )
        }
    }
    Column {
        Card(
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
            colors = CardDefaults.cardColors(containerColor = White),
            modifier = Modifier
                .padding(start = 25.dp, top = 140.dp)
                .size(height = 100.dp, width = 365.dp)
                .background(
                    White, shape = RoundedCornerShape(
                        topStart = 16.dp
                    )
                )
        ) {
            Column {
                Text(
                    "Название препарата",
                    modifier = Modifier
                        .padding(start = 18.dp, top = 22.dp), fontSize = 22.sp
                )
                Text(
                    "Бордоская смесь",
                    fontWeight = FontWeight.Medium,
                    fontSize = 20.sp,
                    fontStyle = FontStyle.Italic,
                    modifier = Modifier
                        .padding(start = 18.dp)
                ) // TODO (образец)
            }
        }
        Card(
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
            colors = CardDefaults.cardColors(containerColor = White),
            modifier = Modifier
                .padding(start = 25.dp, top = 20.dp)
                .size(height = 100.dp, width = 365.dp)
                .background(
                    White, shape = RoundedCornerShape(
                        topStart = 16.dp
                    )
                )
        ) {
            Column {
                Text(
                    "Цель препарата",
                    modifier = Modifier
                        .padding(start = 18.dp, top = 22.dp), fontSize = 22.sp
                )
                Text(
                    "Защита от грибковых заболеваний",
                    fontWeight = FontWeight.Medium,
                    fontSize = 20.sp,
                    fontStyle = FontStyle.Italic,
                    modifier = Modifier
                        .padding(start = 18.dp)
                ) // TODO (образец)
            }
        }
        Card(
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
            colors = CardDefaults.cardColors(containerColor = White),
            modifier = Modifier
                .padding(start = 25.dp, top = 20.dp)
                .size(height = 100.dp, width = 365.dp)
                .background(
                    White, shape = RoundedCornerShape(
                        topStart = 16.dp
                    )
                )
        ) {
            Column {
                Text(
                    "Норма расхода препарата",
                    modifier = Modifier
                        .padding(start = 18.dp, top = 22.dp), fontSize = 22.sp
                )
                Text(
                    "20-30 мг на 10л воды",
                    fontWeight = FontWeight.Medium,
                    fontSize = 20.sp,
                    fontStyle = FontStyle.Italic,
                    modifier = Modifier
                        .padding(start = 18.dp)
                ) // TODO (образец)
            }
        }
    }
}