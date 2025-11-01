package com.example.myapplication.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.presentation.DrugAdd
import com.example.myapplication.presentation.DrugInfo
import com.example.myapplication.presentation.GardenAdd
import com.example.myapplication.presentation.MainScreen
import com.example.myapplication.presentation.PlantAdd

@Composable
fun AppNavigation() {
    // 1. Создаем NavController. Он отвечает за управление состоянием навигации.
    // rememberNavController() гарантирует, что контроллер сохранится при перерисовках.
    val navController = rememberNavController()

    // 2. NavHost - это контейнер, который связывает маршруты с Composable-экранами.
    NavHost(
        navController = navController,
        // 3. Указываем стартовый экран.
        startDestination = AppDestinations.MAINSCREEN_ROUTE // тут путь в Main Screen, Garden везде для примера
    ) {
        composable(route = AppDestinations.MAINSCREEN_ROUTE) {
            MainScreen(navController = navController)
        }
        composable(route = AppDestinations.DRUG_ADD_ROUTE) {
            DrugAdd(navController = navController)
        }
        composable(route = AppDestinations.GARDEN_ADD) {
            GardenAdd(navController = navController)
        }
        composable(route = "drugInfoScreen/{drugName}/{purpose}/{consumptionRate}") { backStackEntry ->
            val drugName = backStackEntry.arguments?.getString("drugName")
            val purpose = backStackEntry.arguments?.getString("purpose")
            val consumptionRate = backStackEntry.arguments?.getString("consumptionRate")
            DrugInfo(navController = navController, drugName, purpose, consumptionRate)
        }
        composable(route = AppDestinations.PLANT_ADD) {
            PlantAdd(navController = navController)
        }
    }
}