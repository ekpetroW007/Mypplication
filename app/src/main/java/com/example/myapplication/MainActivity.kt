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
fun SwitchScreen() {
    var theme by remember { mutableStateOf(false) }
    val textColor = if (theme) Color.Black else Color.White
    val backColor = if (theme) Color.White else Color.Black
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backColor)
    ) {
        Text(
            "switch",
            color = textColor
        )
        Spacer(modifier = Modifier.height(20.dp))
        Switch(
            checked = theme,
            onCheckedChange = { isChecked ->
                theme = isChecked
            },
            modifier = Modifier.background(backColor),
        )
    }
}