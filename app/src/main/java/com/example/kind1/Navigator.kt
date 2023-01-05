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
                route = Screen.Confirmation.route
            ) {
                ConfirmationScreen(navController = navController)
            }
            composable(route = Screen.Template.route) {
                TemplateScreen(navController = navController)
            }
            composable(route = Screen.Portfølje.route) {
                PortføljeNy(navController = navController)
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
                    username = entry.arguments?.getString("username"),
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
                KindStart(
                    username = entry.arguments?.getString("username"),
                    navController = navController
                )
            }
        }
    }
}