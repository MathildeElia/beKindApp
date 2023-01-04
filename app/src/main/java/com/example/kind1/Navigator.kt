package com.example.kind1

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun Navigation() {
    val navController = rememberNavController()

    Card(elevation = 2.dp) {
        Image(
            contentScale = ContentScale.FillBounds,
            painter = painterResource(id = R.drawable.bekindbackground),
            contentDescription = null,
            modifier = Modifier.fillMaxSize()
        )

        NavHost(
            navController = navController,
            startDestination = Screen.KindFront.route
        ) {
            composable(route = Screen.KindFront.route) {
                KindFront(navController = navController)
            }
            composable(
                route = Screen.KindLogin.route
            ) {
                KindLogin(navController = navController)
            }
            composable(
                route = Screen.KindSignUp.route
            ) {
                KindSignUp(navController = navController)
            }
            composable(
                route = Screen.MakeDonatinon.route
            ) {
                //MakeDonationScreen(navController = navController)
            }

            composable(
                route = Screen.KindStart.route + "/{username}", arguments = listOf(
                    navArgument("username") {
                        type = NavType.StringType
                        defaultValue = "Seby"
                        nullable = true
                    }
                )
            ) { entry ->
                KindStart(
                    username = entry.arguments?.getString("username").toString(),
                    navController = navController
                )
            }
            composable(
                route = Screen.KindStart.route + "/{username}", arguments = listOf(
                    navArgument("username") {
                        type = NavType.StringType
                        defaultValue = "Seby"
                        nullable = true
                    }
                )
            ) { entry ->
                entry.arguments?.getString("username")?.let {
                    KindStart(
                        username = it,
                        navController = navController
                    )
                }
            }
            composable(
                route = Screen.MakeDonatinon.route + "/{username}", arguments = listOf(
                    navArgument("username"){
                        type = NavType.StringType
                        defaultValue = "Seby"
                        nullable = true
                    }
                )
            ){ entry ->
                entry.arguments?.getString("username")?.let {
                    MakeDonationScreen(
                        username = it,
                        navController = navController
                    )
                }
            }
            composable(
                route = Screen.Confirmation.route + "/{value}/{username}", arguments = listOf(
                    navArgument("value"){
                        type = NavType.StringType
                        defaultValue = "Seby"
                    },
                    navArgument("username"){
                        type = NavType.StringType
                        defaultValue = "Seby"
                    }
                )
            ){ entry ->
                entry.arguments?.getString("username")?.let {
                    ConfirmationScreen(
                        value = entry.arguments?.getString("value"),
                        username = it,
                        navController = navController
                    )
                }
            }



        }
    }
}