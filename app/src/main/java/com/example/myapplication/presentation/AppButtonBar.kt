package com.example.myapplication.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R

@Composable
fun AppButtonBar(onClick: () -> Unit) {
    Row(modifier = Modifier.padding(5.dp)) {
        NavigationItem("Календарь", onClick)
        NavigationItem("Мои сады", onClick)
        NavigationItem("Препараты", onClick)
        NavigationItem("Профиль", onClick)
    }
}

@Composable
fun NavigationItem(text: String, onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .padding(5.dp)
            .clickable {onClick()},
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            bitmap = ImageBitmap.imageResource(R.drawable.profile),
            contentDescription = "Картинка профиля",
            modifier = Modifier
                .size(7.dp)
        )
        Text(
            text, fontSize = 10.sp,
        )
    }
}

@Preview
@Composable
fun PreviewButtonBar() {
    AppButtonBar {}
}