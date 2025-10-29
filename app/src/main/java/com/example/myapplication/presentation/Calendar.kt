package com.example.myapplication.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import io.github.boguszpawlowski.composecalendar.SelectableWeekCalendar
import io.github.boguszpawlowski.composecalendar.day.DayState
import io.github.boguszpawlowski.composecalendar.selection.DynamicSelectionState
import java.time.DayOfWeek

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Calendar(innerPadding: PaddingValues) {
    Scaffold(modifier = Modifier.padding(innerPadding)) { innerPadding ->
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