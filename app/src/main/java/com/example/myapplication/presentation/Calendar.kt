package com.example.myapplication.presentation

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.myapplication.BookeeperApp
import com.example.myapplication.R
import com.example.myapplication.presentation.navigation.AppDestinations
import com.example.myapplication.viewmodel.DrugsViewmodel
import com.example.myapplication.viewmodel.DrugsViewmodelFactory
import com.example.myapplication.viewmodel.GardensViewmodel
import com.example.myapplication.viewmodel.GardensViewmodelFactory
import com.example.myapplication.viewmodel.PlantsViewmodel
import com.example.myapplication.viewmodel.PlantsViewmodelFactory
import com.example.myapplication.viewmodel.TasksViewmodel
import com.example.myapplication.viewmodel.TasksViewmodelFactory
import io.github.boguszpawlowski.composecalendar.SelectableWeekCalendar
import io.github.boguszpawlowski.composecalendar.day.DayState
import io.github.boguszpawlowski.composecalendar.selection.DynamicSelectionState
import java.time.DayOfWeek

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Calendar(innerPadding: PaddingValues, navController: NavController) {
    val application = LocalContext.current.applicationContext as BookeeperApp
    val viewmodelGardenFactory = GardensViewmodelFactory(application.repository)
    val gardensViewmodel: GardensViewmodel = viewModel(factory = viewmodelGardenFactory)

    val viewmodelDrugsFactory = DrugsViewmodelFactory(application.repository)
    val drugsViewmodel: DrugsViewmodel = viewModel(factory = viewmodelDrugsFactory)

    val viewmodelTasksFactory = TasksViewmodelFactory(application.repository)
    val tasksViewmodel: TasksViewmodel = viewModel(factory = viewmodelTasksFactory)

    val viewmodelPlantsFactory = PlantsViewmodelFactory(application.repository)
    val plantsViewmodel: PlantsViewmodel = viewModel(factory = viewmodelPlantsFactory)
    val plantList by plantsViewmodel.plants.collectAsState()
    LaunchedEffect(Unit) { Log.d("plantList", plantList.toString()) }
    Scaffold(
        modifier = Modifier.padding(innerPadding),
        floatingActionButton = {
            Button(
                onClick = { navController.navigate(AppDestinations.PLANT_ADD) },
                colors = ButtonDefaults.buttonColors(
                    contentColor = White,
                    containerColor = Color(0xFF40BE54)
                )
            ) {
                Text("+")
            }
        }) { innerPadding ->
        Column {
            SelectableWeekCalendar(
                dayContent = { WeekCalendar(it) },
                firstDayOfWeek = DayOfWeek.MONDAY,
            )
            LazyColumn(modifier = Modifier.padding(start = 30.dp, top = 30.dp)) {
                items(plantList) { plant ->
                    DayCard(
                        plant.plantName,
                        plant.taskName,
                        plant.period,
                        plant.plantPhoto,
                        plant.drugId,
                        plant.gardenId,
                        plantsViewmodel,
                        drugsViewmodel,
                        tasksViewmodel,
                        gardensViewmodel,
                        plant.id
                    )
                }
            }
        }
    }
}

@Composable
fun WeekCalendar(dayState: DayState<DynamicSelectionState>) {
    Column {
        Text(
            text = dayState.date.dayOfMonth.toString(),
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun DayCard(
    plantName: String,
    taskName: String,
    period: Int,
    plantPhoto: String,
    drugId: Int?,
    gardenId: Int?,
    plantsViewmodel: PlantsViewmodel,
    drugsViewmodel: DrugsViewmodel,
    tasksViewmodel: TasksViewmodel,
    gardensViewmodel: GardensViewmodel,
    id: Int
) {
    val application = LocalContext.current.applicationContext as BookeeperApp
    val viewmodelTasksFactory = TasksViewmodelFactory(application.repository)
    val tasksViewmodel: TasksViewmodel = viewModel(factory = viewmodelTasksFactory)
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = White),
        modifier = Modifier
            .padding(top = 8.dp)
            .size(height = 140.dp, width = 340.dp)
            .background(
                color = Color(0xFFFBFCFB), shape = RoundedCornerShape(
                    topStart = 16.dp,
                )
            )
    ) {
        Column(modifier = Modifier.padding(start = 100.dp, top = 20.dp)) {
            Row {
                Text(
                    plantName,
                    fontSize = 25.sp,
                    modifier = Modifier.padding(top = 3.dp),
                    color = Color(0xFF000000),
                    fontWeight = FontWeight.Medium
                )
                Box(
                    modifier = Modifier
                        .background(
                            color = Color(0xFFA2FFAC), shape = RoundedCornerShape(
                                topStart = 16.dp,
                            )
                        )
                        .padding(start = 40.dp)
                        .size(width = 20.dp, height = 20.dp),
                ) {
                    Text(
                        gardenId.toString(),
                        modifier = Modifier
                            .fillMaxSize()
                            .wrapContentSize(Alignment.Center),
                        fontSize = 20.sp,
                        color = Color(0xFF075E10),
                    )
                }

            }
            Text(
                drugId.toString(),
                fontSize = 17.sp,
                modifier = Modifier.padding(top = 3.dp),
                color = Color(0xFF000000),
            )
            Text(
                taskName,
                fontSize = 17.sp,
                modifier = Modifier.padding(top = 3.dp),
                color = Color(0xFF000000),
            )
            Row {
                Text(
                    period.toString(),
                    fontSize = 17.sp,
                    modifier = Modifier.padding(top = 3.dp),
                    color = Color(0xFF000000),
                )
                Image(
                    bitmap = ImageBitmap.imageResource(R.drawable.delete),
                    contentDescription = "Удалить",
                    modifier = Modifier
                        .padding(start = 100.dp)
                        .size(15.dp, 20.dp)
                        .clickable { plantsViewmodel.deletePlant(id); tasksViewmodel.deleteTask(id) }
                )
            }
        }

    }
}