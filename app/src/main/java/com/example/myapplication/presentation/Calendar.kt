package com.example.myapplication.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.myapplication.presentation.navigation.AppDestinations
import com.example.myapplication.viewmodel.DrugsViewmodel
import com.example.myapplication.viewmodel.GardensViewmodel
import com.example.myapplication.viewmodel.PlantsViewmodel
import com.example.myapplication.viewmodel.TasksViewmodel
import io.github.boguszpawlowski.composecalendar.SelectableWeekCalendar
import io.github.boguszpawlowski.composecalendar.day.DayState
import io.github.boguszpawlowski.composecalendar.selection.DynamicSelectionState
import java.time.DayOfWeek

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Calendar(innerPadding: PaddingValues, navController: NavController) {
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

        SelectableWeekCalendar(dayContent = { WeekCalendar(it) }, firstDayOfWeek = DayOfWeek.MONDAY)

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
    drugName: String,
    taskName: String,
    gardenName: String,
    plantsViewmodel: PlantsViewmodel,
    drugsViewmodel: DrugsViewmodel,
    tasksViewmodel: TasksViewmodel,
    gardensViewmodel: GardensViewmodel,
    id: Int
) {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = White),
        modifier = Modifier
            .padding(top = 40.dp)
            .size(height = 120.dp, width = 365.dp)
            .background(
                color = Color(0xFFFBFCFB), shape = RoundedCornerShape(
                    topStart = 16.dp,
                )
            )
    ) {
        Column {
            Row {
                Text(
                    plantName,
                    fontSize = 25.sp,
                    modifier = Modifier.padding(top = 43.dp, start = 30.dp),
                    color = Color(0xFF000000),
                    fontWeight = FontWeight.Medium
                )
                Text(
                    gardenName,
                    fontSize = 25.sp,
                    modifier = Modifier.padding(top = 43.dp, start = 30.dp),
                    color = Color(0xFF000000),
                    fontWeight = FontWeight.Medium
                )
            }
            Text(
                drugName,
                fontSize = 25.sp,
                modifier = Modifier.padding(top = 43.dp, start = 30.dp),
                color = Color(0xFF000000),
                fontWeight = FontWeight.Medium
            )
            Text(
                taskName,
                fontSize = 25.sp,
                modifier = Modifier.padding(top = 43.dp, start = 30.dp),
                color = Color(0xFF000000),
                fontWeight = FontWeight.Medium
            )
            Text(
                plantName,
                fontSize = 25.sp,
                modifier = Modifier.padding(top = 43.dp, start = 30.dp),
                color = Color(0xFF000000),
                fontWeight = FontWeight.Medium
            )
        }

    }
}