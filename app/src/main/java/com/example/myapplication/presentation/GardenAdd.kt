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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.myapplication.BookeeperApp
import com.example.myapplication.R
import com.example.myapplication.viewmodel.GardensViewmodel
import com.example.myapplication.viewmodel.GardensViewmodelFactory

@Composable
fun GardenAdd(navController: NavController) { // TODO (тут в карточки садов будет добавляться инофрмация с экрана календаря)
    val name = remember { mutableStateOf("") }
    val application = LocalContext.current.applicationContext as BookeeperApp
    val viewmodelFactory = GardensViewmodelFactory(application.repository)
    val gardensViewmodel: GardensViewmodel = viewModel(factory = viewmodelFactory)
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
                "Добавление сада",
                modifier = Modifier.padding(start = 22.dp, top = 28.dp),
                fontSize = 35.sp,
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
                    "Название сада",
                    modifier = Modifier
                        .padding(start = 18.dp, top = 22.dp), fontSize = 22.sp
                )

                Text(name.value, fontSize = 20.sp)
                TextField(
                    value = name.value,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                    textStyle = TextStyle(fontSize = 20.sp),
                    onValueChange = { newText -> name.value = newText }
                )
            }
        }
        Button(
            onClick = {
                gardensViewmodel.gardenAdd(name.value)
                navController.popBackStack()
            }, modifier = Modifier
                .padding(start = 25.dp, top = 40.dp)
                .size(height = 70.dp, width = 365.dp)
                .background(
                    White, shape = RoundedCornerShape(
                        topStart = 16.dp,
                    )
                ), colors = ButtonDefaults.buttonColors(
                contentColor = White,
                containerColor = Color(0xFF40BE54),

                )
        ) {
            Text(
                "Cохранить", fontSize = 25.sp, modifier = Modifier
                    .padding(horizontal = 22.dp)
            )
        }

    }
}