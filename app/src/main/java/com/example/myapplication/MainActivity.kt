package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.myapplication.navigation.Navigation
import com.example.myapplication.ui.theme.ListAdder
import com.example.myapplication.ui.theme.ScreenChange

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Navigation()
        }
    }
}

@Composable
fun Profile() {
    Row {
        Box(
            modifier = Modifier
                .size(100.dp, 100.dp)
                .background(Color.Green)
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
                .background(Color.Green)
        ) {
            Column {
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    "Профиль",
                    fontSize = 35.sp,
                    color = Color.White,
                    fontWeight = Bold
                )
                Text(
                    email,
                    fontSize = 20.sp,
                    color = Color.White,
                    fontWeight = Bold
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
    Row {
        Card(

        ) {
            Column {
                Text(
                    "1",
                    modifier = Modifier.fillMaxWidth(1f),
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center
                )
                Text(
                    "Садов",
                    modifier = Modifier.fillMaxWidth(1f),
                    fontSize = 15.sp,
                    textAlign = TextAlign.Center
                )
            }
        }
        Spacer(modifier = Modifier.width(15.dp))
        Card(
            modifier = Modifier
                .size(height = 70.dp, width = 90.dp)
        ) {
            Column {
                Text(
                    "2",
                    modifier = Modifier.fillMaxWidth(1f),
                    fontSize = 20.sp,
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
        Spacer(modifier = Modifier.width(15.dp))
        Card(
            modifier = Modifier
                .size(height = 70.dp, width = 115.dp)
        ) {
            Column {
                Text(
                    "2",
                    modifier = Modifier.fillMaxWidth(1f),
                    fontSize = 20.sp,
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
        Spacer(modifier = Modifier.width(15.dp))
        Card(
            modifier = Modifier
                .size(70.dp)
        ) {
            Column {
                Text(
                    "2",
                    modifier = Modifier.fillMaxWidth(1f),
                    fontSize = 20.sp,
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