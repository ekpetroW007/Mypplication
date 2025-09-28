package com.example.myapplication

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

//data class User(val name: String, val age: Int)
//
//@Composable
//fun UserListScreen(navController: NavController) {
//    val users = listOf(User("X", 20), User("Y", 50), User("W", 100))
//    LazyColumn {
//        items(users) { user ->
//            Text(
//                "name: ${user.name}, age: ${user.age}",
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(16.dp)
//                    .clickable {
//                        navController.navigate("userDetail/${user.name}/${user.age}")
//                    }
//            )
//
//        }
//        item {
//            Text(
//                "Перейти на третий экран", modifier = Modifier.padding(16.dp).clickable {
//                    navController.navigate("screenReplace")
//                }
//            )
//        }
//    }
//}