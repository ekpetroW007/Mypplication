package com.example.myapplication

import androidx.compose.ui.text.font.FontStyle
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Profile()
        }
    }
}

var email = "email@gmail.com" // ВВОДИТ ПОЛЬЗОВАТЕЛЬ

@Composable
fun Profile() {
    Row {
        Box(
            modifier = Modifier
                .size(100.dp, 100.dp)
                .background(Color(0xFF18C933))
        ) {
            Image(
                bitmap = ImageBitmap.imageResource(R.drawable.profile),
                contentDescription = "Картинка профиля",
                modifier = Modifier
                    .padding(horizontal = 10.dp)
                    .size(70.dp, 100.dp)
            )
        }
        Box(
            modifier = Modifier
                .size(500.dp, 100.dp)
                .background(Color(0xFF18C933))
        ) {
            Column {
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    "Профиль",
                    fontSize = 35.sp,
                    color = White,
                    fontWeight = Bold
                )
                Text(
                    email,
                    fontSize = 20.sp,
                    color = White
                )
            }
        }
    }
    Text(
        "Статистика",
        fontSize = 25.sp,
        fontWeight = Bold,
        color = Color.Black,
        modifier = Modifier.padding(vertical = 130.dp, horizontal = 20.dp)
    )

    Row(modifier = Modifier.padding(vertical = 185.dp, horizontal = 20.dp)) {
        Card(
            modifier = Modifier
                .size(70.dp)
                .background(
                    White, shape = RoundedCornerShape(
                        topStart = 16.dp,
                        topEnd = 16.dp,
                        bottomEnd = 0.dp,
                        bottomStart = 0.dp
                    )
                )
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.Center)
            ) {
                Column(
                    modifier = Modifier.align(Alignment.Center),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        "1", // TODO (будет браться из вьюмодели)
                        color = Color(0xFF18C933),
                        modifier = Modifier.fillMaxWidth(1f),
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center, fontWeight = Bold
                    )
                    Text(
                        "Садов",
                        modifier = Modifier.fillMaxWidth(1f),
                        fontSize = 15.sp,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
        Spacer(modifier = Modifier.width(15.dp))
        Card(
            modifier = Modifier
                .size(height = 70.dp, width = 90.dp)
                .background(
                    White, shape = RoundedCornerShape(
                        topStart = 16.dp,
                        topEnd = 16.dp,
                        bottomEnd = 0.dp,
                        bottomStart = 0.dp
                    )
                )
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.Center)
            ) {
                Column(
                    modifier = Modifier.align(Alignment.Center),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        "2",
                        color = Color(0xFF18C933),
                        modifier = Modifier.fillMaxWidth(1f),
                        fontSize = 20.sp, fontWeight = Bold,
                        textAlign = TextAlign.Center
                    )
                    Text(
                        "Растений",
                        modifier = Modifier.fillMaxWidth(1f),
                        fontSize = 15.sp,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
        Spacer(modifier = Modifier.width(15.dp))
        Card(
            modifier = Modifier
                .size(height = 70.dp, width = 100.dp)
                .background(
                    White, shape = RoundedCornerShape(
                        topStart = 16.dp,
                        topEnd = 16.dp,
                        bottomEnd = 0.dp,
                        bottomStart = 0.dp
                    )
                )
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.Center)
            ) {
                Column(
                    modifier = Modifier.align(Alignment.Center),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        "2",
                        color = Color(0xFF18C933),
                        modifier = Modifier.fillMaxWidth(1f),
                        fontSize = 20.sp, fontWeight = Bold,
                        textAlign = TextAlign.Center
                    )
                    Text(
                        "Препаратов",
                        modifier = Modifier.fillMaxWidth(1f),
                        fontSize = 15.sp,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
        Spacer(modifier = Modifier.width(15.dp))
        Card(
            modifier = Modifier
                .size(height = 70.dp, width = 85.dp)
                .background(
                    White, shape = RoundedCornerShape(
                        topStart = 16.dp,
                        topEnd = 16.dp,
                        bottomEnd = 0.dp,
                        bottomStart = 0.dp
                    )
                )
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.Center)
            ) {
                Column(
                    modifier = Modifier.align(Alignment.Center),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        "2",
                        color = Color(0xFF18C933),
                        modifier = Modifier.fillMaxWidth(1f),
                        fontSize = 20.sp, fontWeight = Bold,
                        textAlign = TextAlign.Center
                    )
                    Text(
                        "Задач",
                        modifier = Modifier.fillMaxWidth(1f),
                        fontSize = 15.sp,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
    Card(
        modifier = Modifier
            .padding(vertical = 270.dp, horizontal = 20.dp)
            .size(height = 150.dp, width = 375.dp)
            .background(
                White, shape = RoundedCornerShape(
                    topStart = 16.dp,
                    topEnd = 16.dp,
                    bottomEnd = 0.dp,
                    bottomStart = 0.dp
                )
            )
    ) {
        Row {
            Image(
                bitmap = ImageBitmap.imageResource(R.drawable.picofplant),
                contentDescription = "Картинка растения в профиле",
                modifier = Modifier
                    .padding(horizontal = 22.dp)
                    .size(50.dp, 80.dp)
            )
            Column {
                Text(
                    "Bookeeper",
                    modifier = Modifier
                        .padding(start = 0.dp, top = 23.dp, end = 0.dp, bottom = 3.dp),
                    fontSize = 30.sp,
                    letterSpacing = 0.3.em,
                    fontWeight = Bold,
                    color = Color(0xFF000000)
                )

            }
        }
    }
    Text(
        "Приложение для планирования и учета обработки растений в саду. Создавайте графики работ, отслеживайте выполнение и ведите историю обработок.",
        modifier = Modifier
            .padding(vertical = 345.dp, horizontal = 42.dp),
        fontSize = 14.sp,
        fontStyle = FontStyle.Italic,
        color = Color(0xFF000000)
    )
}