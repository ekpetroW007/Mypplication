package com.example.myapplication.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.presentation.MyGardens

//@Composable
//fun AppNavigation() {
//    // 1. Создаем NavController. Он отвечает за управление состоянием навигации.
//    // rememberNavController() гарантирует, что контроллер сохранится при перерисовках.
//    val navController = rememberNavController()
//
//    // 2. NavHost - это контейнер, который связывает маршруты с Composable-экранами.
//    NavHost(
//        navController = navController,
//        // 3. Указываем стартовый экран.
//        startDestination = AppDestinations.GARDEN_ROUTE // тут путь в Main Screen, Garden везде для примера
//    ) {
//        // 4. Определяем первый экран в нашем графе навигации.
//        composable(route = AppDestinations.GARDEN_ROUTE) {
//            // Когда маршрут совпадает с GARDEN_ROUTE, будет показан GardenScreen.
//            // Мы передаем ему navController, чтобы он мог инициировать переходы на другие экраны.
//            MyGardens(navController = navController)
//        }
//
//    }
//}