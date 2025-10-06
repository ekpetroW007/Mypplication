package com.example.myapplication.others

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun ScreenFour(
    navController: NavController,
    message: String? // заметь, это nullable строка!!
) {
    Column {
        Text(
            // просто text = message не получилось бы из-за
            // того, что это nullable строка!!
            // но можно text = message ?: ""
            text = "Screen 4 with message: $message",
            modifier = Modifier.padding(16.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        TextButton(
            onClick = {
                navController.popBackStack()
            }
        ) {
            Text("Go Back")
        }
    }

}