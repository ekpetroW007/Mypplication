package com.example.myapplication.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.myapplication.ScreenReplace
import com.example.myapplication.UserDetailScreen
import com.example.myapplication.UserListScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "userList") {
        composable("userList") {
            UserListScreen(navController = navController)
        }
        composable(
            "userDetail/{userName}/{userAge}",
            arguments = listOf(
                navArgument("userName") {
                    type = NavType.StringType
                },
                navArgument("userAge") {
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->
            val userName = backStackEntry.arguments?.getString("userName")
            val userAge = backStackEntry.arguments?.getInt("userAge")
            UserDetailScreen(userName ?: "", userAge ?: 0)
        }
        composable("screenReplace") {
            ScreenReplace(navController = navController)
        }
        composable ("screenFour") {

        }
    }
}