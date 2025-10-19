package com.example.myapplication.presentation

import android.graphics.fonts.FontStyle
import androidx.compose.material3.Button
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.myapplication.BookeeperApp
import com.example.myapplication.R
import com.example.myapplication.presentation.navigation.AppDestinations
import com.example.myapplication.viewmodel.DrugsViewmodel
import com.example.myapplication.viewmodel.DrugsViewmodelFactory

@Composable
fun Drugs(
    navController: NavController
) {

    val application = LocalContext.current.applicationContext as BookeeperApp
    val viewmodelFactory = DrugsViewmodelFactory(application.repository)
    val drugsViewmodel: DrugsViewmodel = viewModel(factory = viewmodelFactory)
    val drugList by drugsViewmodel.drugs.collectAsState()

    Scaffold(
        floatingActionButton = {
            Button(onClick = {navController.navigate(AppDestinations.DRUG_ADD_ROUTE)}) {
                Text("+")
            }
        }
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            Card(
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                colors = CardDefaults.cardColors(containerColor = White),
                border = BorderStroke(1.dp, Color(0xFF000000)),
                modifier = Modifier
                    .padding(start = 25.dp, top = 140.dp, end = 0.dp, bottom = 0.dp)
                    .size(height = 45.dp, width = 365.dp)
                    .background(
                        White, shape = RoundedCornerShape(
                            topStart = 16.dp,
                            topEnd = 0.dp,
                            bottomEnd = 0.dp,
                            bottomStart = 0.dp
                        )
                    )
            ) {
                Row {
                    Image(
                        bitmap = ImageBitmap.imageResource(R.drawable.search),
                        contentDescription = "Картинка поиска",
                        modifier = Modifier
                            .padding(horizontal = 22.dp)
                            .size(20.dp, 45.dp)
                    )
                    Text(
                        "Поиск использованных препаратов...",
                        modifier = Modifier
                            .padding(vertical = 14.dp),
                        fontSize = 15.sp,
                        color = Color(0xD2343538)
                    )
                }
            }
            LazyColumn(modifier = Modifier.padding(start = 25.dp, top = 200.dp)) {
                items(drugList) { drug ->
                    DrugCard(drug.name, drug.purpose, drug.consumptionRate)
                }
            }
        }
    }
}

@Composable
fun DrugCard(drugName: String, drugTarget: String, drugAmount: String) {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = White),
        modifier = Modifier
            .padding(top = 20.dp)
            .size(height = 200.dp, width = 365.dp)
            .background(
                White, shape = RoundedCornerShape(
                    topStart = 16.dp,
                )
            )
    ) {
        Row {
            Image(
                bitmap = ImageBitmap.imageResource(R.drawable.drug),
                contentDescription = "Картинка препарата",
                modifier = Modifier
                    .padding(horizontal = 22.dp, vertical = 25.dp)
                    .size(30.dp, 55.dp)
            )
            Column {
                Text(
                    drugName,
                    fontSize = 21.sp, modifier = Modifier.padding(top = 23.dp),
                    color = Color(0xFF000000), fontWeight = FontWeight.Bold
                )
                Text(
                    drugTarget,
                    fontSize = 16.sp,
                    color = Color(0xFF6C6A6A)
                )
            }
        }
        HorizontalDivider(thickness = 1.dp)
        Column {
            Text(
                "Норма расхода: ",
                fontSize = 15.sp, modifier = Modifier.padding(start = 22.dp, top = 12.dp),
                color = Color(0xFF6C6A6A)
            )
            Text(
                drugAmount,
                fontSize = 17.sp, modifier = Modifier.padding(start = 22.dp),
                color = Color(0xFF333030), fontWeight = FontWeight.Bold
            )
        }

        // TODO (как в апбатонбар сделать карточки)
    }
}