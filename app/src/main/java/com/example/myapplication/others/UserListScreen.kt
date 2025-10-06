package com.example.myapplication.others

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