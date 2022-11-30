package com.example.kind1

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = Screen.KindFront.route){
        composable(route = Screen.KindFront.route){
            KindFront(navController = navController)
        }
        composable(
            route = Screen.KindLogin.route){
            KindLogin(navController = navController)
        }
        composable(
            route = Screen.KindSignUp.route){
            KindSignUp(navController = navController)
        }

        composable(
            route = Screen.KindStart.route + "/{username}", arguments = listOf(
                navArgument("username"){
                    type = NavType.StringType
                    defaultValue = "Seby"
                    nullable = true
                }
            )
        ){entry ->
            KindStart(username = entry.arguments?.getString("username"), navController = navController)
        }
        composable(
            route = Screen.KindStart.route + "/{username}", arguments = listOf(
                navArgument("username"){
                    type = NavType.StringType
                    defaultValue = "Seby"
                    nullable = true
                }
            )
        ){entry ->
            KindStart(username = entry.arguments?.getString("username"), navController = navController)
        }


    }
}