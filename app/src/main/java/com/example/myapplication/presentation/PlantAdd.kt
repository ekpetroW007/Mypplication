package com.example.myapplication.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.myapplication.BookeeperApp
import com.example.myapplication.R
import com.example.myapplication.viewmodel.DrugsViewmodel
import com.example.myapplication.viewmodel.DrugsViewmodelFactory
import com.example.myapplication.viewmodel.PlantsViewmodel
import com.example.myapplication.viewmodel.PlantsViewmodelFactory

@Composable
fun PlantAdd(
    navController: NavController,
) {
    val application = LocalContext.current.applicationContext as BookeeperApp
    val viewmodelFactory = PlantsViewmodelFactory(application.repository)
    val plantsViewmodel: PlantsViewmodel = viewModel(factory = viewmodelFactory)
    val plantName = remember { mutableStateOf("") }
    val drugName = remember { mutableIntStateOf(0) }
    val taskName = remember { mutableStateOf("") }
    val gardenId = remember { mutableIntStateOf(0) }
    val period = remember { mutableIntStateOf(0) }
    val plantPhoto = remember { mutableStateOf("") }
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
        Image(
            bitmap = ImageBitmap.imageResource(R.drawable.arrow),
            contentDescription = "Стрелка",
            modifier = Modifier
                .padding(start = 22.dp, top = 28.dp)
                .size(35.dp, 40.dp)
                .clickable { navController.popBackStack() }
        )
    }
    Column {
        Text(
            "Название растения:",
            modifier = Modifier.padding(top = 120.dp, start = 20.dp),
            fontSize = 20.sp
        )

        Text(
            plantName.value,
            fontSize = 20.sp,
            modifier = Modifier.padding(top = 5.dp, start = 20.dp)
        )
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

        Text(
            drugName.value,
            fontSize = 20.sp,
            modifier = Modifier.padding(top = 5.dp, start = 20.dp)
        )
        TextField(
            value = drugName.value,
            textStyle = TextStyle(fontSize = 20.sp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
            onValueChange = { newText -> drugName.value = newText }
        )
        Text(
            "Задача:",
            modifier = Modifier.padding(top = 20.dp, start = 20.dp),
            fontSize = 20.sp
        )

        Text(
            taskName.value,
            fontSize = 20.sp,
            modifier = Modifier.padding(top = 5.dp, start = 20.dp)
        )
        TextField(
            value = taskName.value,
            textStyle = TextStyle(fontSize = 20.sp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
            onValueChange = { newText -> taskName.value = newText }
        )
        Text(
            "Название сада:",
            modifier = Modifier.padding(top = 20.dp, start = 20.dp),
            fontSize = 20.sp
        )

        Text(
            gardenName.value,
            fontSize = 20.sp,
            modifier = Modifier.padding(top = 5.dp, start = 20.dp)
        )
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

        Text(
            plantPhoto.value,
            fontSize = 20.sp,
            modifier = Modifier.padding(top = 5.dp, start = 20.dp)
        )
        TextField(
            value = plantPhoto.value,
            textStyle = TextStyle(fontSize = 20.sp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
            onValueChange = { newText -> plantPhoto.value = newText }
        )
        Button(
            onClick = {
                plantsViewmodel.addPlant(plantName.value, taskName.value, consumptionRate.value)
                navController.popBackStack()

            },
            modifier = Modifier
                .padding(start = 25.dp, top = 40.dp)
                .size(height = 70.dp, width = 365.dp)
                .background(
                    White, shape = RoundedCornerShape(
                        topStart = 16.dp,
                    )
                ),
            colors = ButtonDefaults.buttonColors(
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