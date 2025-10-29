package com.example.myapplication.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import com.example.myapplication.presentation.navigation.AppDestinations
import io.github.boguszpawlowski.composecalendar.SelectableWeekCalendar
import io.github.boguszpawlowski.composecalendar.day.DayState
import io.github.boguszpawlowski.composecalendar.selection.DynamicSelectionState
import java.time.DayOfWeek

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Calendar(innerPadding: PaddingValues, navController: NavController) {
    Scaffold(modifier = Modifier.padding(innerPadding),
        floatingActionButton = {
            Button(
                onClick = { navController.navigate(AppDestinations.DRUG_ADD_ROUTE) },
                colors = ButtonDefaults.buttonColors(
                    contentColor = White,
                    containerColor = Color(0xFF40BE54)
                )
            ) {
                Text("+")
            }
        }) { innerPadding ->

        SelectableWeekCalendar(dayContent = {DayCard(it)}, firstDayOfWeek = DayOfWeek.MONDAY)

    }
}

@Composable
fun DayCard(dayState: DayState<DynamicSelectionState>) {
    Column {
        Text(
            text = dayState.date.dayOfMonth.toString(),
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
//        Text(
//            text = dayState.date.dayOfMonth.toString(),
//            modifier = Modifier.fillMaxWidth(),
//            textAlign = TextAlign.Center
//        )
    }
}