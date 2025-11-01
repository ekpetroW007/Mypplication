package com.example.myapplication.presentation

import java.time.LocalDate
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.example.myapplication.data.database.entity.DrugEntity
import com.example.myapplication.data.database.entity.GardenEntity
import com.example.myapplication.viewmodel.DrugsViewmodel
import com.example.myapplication.viewmodel.DrugsViewmodelFactory
import com.example.myapplication.viewmodel.GardensViewmodel
import com.example.myapplication.viewmodel.GardensViewmodelFactory
import com.example.myapplication.viewmodel.PlantsViewmodel
import com.example.myapplication.viewmodel.PlantsViewmodelFactory
import com.example.myapplication.viewmodel.TasksViewmodel
import com.example.myapplication.viewmodel.TasksViewmodelFactory

@Composable
fun PlantAdd(
    navController: NavController,
) {
    val application = LocalContext.current.applicationContext as BookeeperApp
    val viewmodelFactoryPlant = PlantsViewmodelFactory(application.repository)
    val plantsViewmodel: PlantsViewmodel = viewModel(factory = viewmodelFactoryPlant)
    val viewmodelFactoryDrug = DrugsViewmodelFactory(application.repository)
    val drugsViewmodel: DrugsViewmodel = viewModel(factory = viewmodelFactoryDrug)
    val drugList by drugsViewmodel.drugs.collectAsState()
    val viewmodelFactoryGarden = GardensViewmodelFactory(application.repository)
    val gardensViewmodel: GardensViewmodel = viewModel(factory = viewmodelFactoryGarden)
    val viewmodelTasksFactory = TasksViewmodelFactory(application.repository)
    val tasksViewmodel: TasksViewmodel = viewModel(factory = viewmodelTasksFactory)
    val gardenList by gardensViewmodel.gardens.collectAsState()
    val plantName = remember { mutableStateOf("") }
    val plantPhoto = remember { mutableStateOf("") }
    val taskName = remember { mutableStateOf("") }
    val gardenId = remember { mutableStateOf<Int?>(null) }
    val gardenName = remember { mutableStateOf<String?>(null) }
    val period = remember { mutableIntStateOf(0) }
    val drugId = remember { mutableStateOf<Int?>(null) }
    var expanded1 by remember { mutableStateOf(false) }
    var expanded2 by remember { mutableStateOf(false) }
//    val firstDayOfPeriod = LocalDate.now()
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
            fontSize = 15.sp
        )

        Text(
            plantName.value,
            fontSize = 15.sp,
            modifier = Modifier.padding(top = 5.dp, start = 20.dp)
        )
        TextField(
            value = plantName.value,
            textStyle = TextStyle(fontSize = 20.sp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
            onValueChange = { newText -> plantName.value = newText }
        )

        Text(
            "Выберите препарат:",
            modifier = Modifier
                .padding(top = 20.dp, start = 20.dp)
                .clickable() { expanded1 = !expanded1 },
            fontSize = 15.sp
        )
        Text(
            drugId.value.toString(),
            fontSize = 15.sp,
            modifier = Modifier.padding(top = 5.dp, start = 20.dp)
        )
        DrugDropdown(
            drugList,
            expanded1,
            { expanded1 = false },
            { drugId.value = it })
        Text(
            "Задача:",
            modifier = Modifier.padding(top = 20.dp, start = 20.dp),
            fontSize = 15.sp
        )

        Text(
            taskName.value,
            fontSize = 15.sp,
            modifier = Modifier.padding(top = 5.dp, start = 20.dp)
        )
        TextField(
            value = taskName.value,
            textStyle = TextStyle(fontSize = 20.sp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
            onValueChange = { newText -> taskName.value = newText }
        )


        Text(
            "Выберите сад:",
            modifier = Modifier
                .padding(top = 20.dp, start = 20.dp)
                .clickable() { expanded2 = !expanded2 },
            fontSize = 15.sp
        )
        Text(
            gardenName.value.toString(),
            fontSize = 15.sp,
            modifier = Modifier.padding(top = 5.dp, start = 20.dp)
        )
        GardenDropdown(gardenList, expanded2, { expanded2 = false }, { gardenId.value = it })


        Text(
            "Интервал полива:",
            modifier = Modifier.padding(top = 20.dp, start = 20.dp),
            fontSize = 15.sp
        )

        Text(
            period.intValue.toString(),
            fontSize = 15.sp,
            modifier = Modifier.padding(top = 5.dp, start = 20.dp)
        )
        TextField(
            value = period.intValue.toString(),
            textStyle = TextStyle(fontSize = 20.sp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            onValueChange = { newText ->
                period.intValue = newText.filter { it.isDigit() }.toInt()
            }
        )
        Text(
            "Фото:",
            modifier = Modifier.padding(top = 20.dp, start = 20.dp),
            fontSize = 15.sp
        )

        Text(
            plantPhoto.value,
            fontSize = 15.sp,
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
                plantsViewmodel.addPlant(
                    plantName.value,
                    taskName.value,
                    period.intValue,
                     LocalDate.now(),
                    plantPhoto.value,
                    drugId.value,
                    gardenId.value
                )
                tasksViewmodel.addTask(taskName.value)
                navController.popBackStack()

            },
            modifier = Modifier
                .padding(start = 25.dp, top = 15.dp)
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

@Composable
fun DrugDropdown(
    drugList: List<DrugEntity>,
    expanded1: Boolean,
    onClick1: () -> Unit,
    onClick2: (Int) -> Unit
) {

    Box(
        modifier = Modifier
            .padding(16.dp)
    ) {
        DropdownMenu(
            expanded = expanded1,
            onDismissRequest = { onClick1() }
        ) {
            drugList.forEach { drug ->
                DropdownMenuItem(
                    text = { Text(drug.name) },
                    onClick = { onClick2(drug.id) }
                )
            }
        }
    }
}

@Composable
fun GardenDropdown(
    gardenList: List<GardenEntity>,
    expanded2: Boolean,
    onClick1: () -> Unit,
    onClick2: (Int) -> Unit
) {

    Box(
        modifier = Modifier
            .padding(16.dp)
    ) {
        DropdownMenu(
            expanded = expanded2,
            onDismissRequest = { onClick1() }
        ) {
            gardenList.forEach { garden ->
                DropdownMenuItem(
                    text = { Text(garden.name) },
                    onClick = { onClick2(garden.id) }
                )
            }
        }
    }
}