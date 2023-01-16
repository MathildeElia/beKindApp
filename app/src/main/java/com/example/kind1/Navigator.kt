package com.example.kind1

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@SuppressLint("SuspiciousIndentation")
@Composable
fun Navigation() {
    val navController = rememberNavController()
    val orgVM = Viewmodel()
    val temaVM = VMtema()

        NavHost(
            navController = navController,
            startDestination = Screen.Miljo.route
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
                route = Screen.MakeDonation.route
            ) {
                MakeDonationScreen(navController = navController)
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
            composable(route = Screen.BygPortfølje.route) {
                BygPortfølje(navController = navController)
            }
            composable(route = Screen.Organisation.route) {
                Organisation(navController = navController, "World Wildlife Fund", orgVM)
            }

            composable(route = Screen.Menu.route) {
                Menu(navController = navController)
            }
            /*
            composable(route = Screen.Tema.route) {
                Tema(navController = navController)
            }

            composable(route = Screen.Sundhed.route) {
                Sundhed(navController = navController)
            }
            composable(route = Screen.SocialtUdsatte.route) {
                SocialtUdsatte(navController = navController)
            }
            composable(route = Screen.Dyrevelfærd.route) {
                Dyrevelfærd(navController = navController)
            }
             */
            composable(route = Screen.Hjælp.route) {
                Hjælp(navController = navController)
            }




            composable(route = Screen.Tema.route) {
                //Miljø(navController = navController)
                Tema(theme = "Miljø", navController = navController, viewmodel = temaVM )
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
                route = Screen.MinKonto.route + "/{username}", arguments = listOf(
                    navArgument("username") {
                        type = NavType.StringType
                        defaultValue = "Seby"
                        nullable = true
                    }
                )
            ) { entry ->
                MinKonto(
                    username = entry.arguments?.getString("username"),
                    navController = navController
                )
            }
            composable(
                route = Screen.TekniskProblem.route + "/{username}", arguments = listOf(
                    navArgument("username") {
                        type = NavType.StringType
                        defaultValue = "Seby"
                        nullable = true
                    }
                )
            ) { entry ->
                TekniskProblem(
                    username = entry.arguments?.getString("username"),
                    navController = navController
                )
            }
        }
}