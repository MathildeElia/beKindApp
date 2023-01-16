package com.example.kind1

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.kind1.viewlmodel.VMdonation

@SuppressLint("SuspiciousIndentation")
@Composable
fun Navigation() {
    val navController = rememberNavController()
    val orgVM = Viewmodel()
    val temaVM = VMtema()
    val donationVM = VMdonation()

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
            /*
            composable(
                route = Screen.MakeDonation.route
            ) {
                MakeDonationScreen(navController = navController)
            }

             */
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
            composable(route = Screen.Sikkerhed.route) {
                Sikkerhed(navController = navController)
            }
            composable(route = Screen.Miljo.route) {
                Miljø(navController = navController)
            }
            composable(route = Screen.Sundhed.route) {
                Sundhed(navController = navController)
            }
            composable(route = Screen.LoadingAnimationScreen.route) {
                LoadingAnimationScreen(navController = navController)
            }
            composable(route = Screen.SocialtUdsatte.route) {
                SocialtUdsatte(navController = navController)
            }
            composable(route = Screen.Dyrevelfærd.route) {
                Dyrevelfærd(navController = navController)
            }
            composable(route = Screen.Hjælp.route) {
                Hjælp(navController = navController)
            }
            composable(route = Screen.KindBekræftet.route) {
                KindBekræftet(navController = navController)
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

            composable(
                route = Screen.MakeDonation.route + "/{username}/{organisation}", arguments = listOf(
                    navArgument("username") {
                        type = NavType.StringType
                        defaultValue = "Seby"
                        nullable = false
                    },
                    navArgument("organisation") {
                        type = NavType.StringType
                        defaultValue = "Plant et Træ"
                        nullable = false
                    }
                )
            ) { entry ->
                MakeDonationScreen(
                    username = entry.arguments?.getString("username"),
                    organisation = entry.arguments?.getString("organisation").toString(),
                    navController = navController,
                    vm = donationVM
                )
            }
        }
}