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
                route = Screen.MakeDonation.route+ "/{username}", arguments = listOf(
                    navArgument("username") {
                        type = NavType.StringType
                        defaultValue = "Seby"
                        nullable = true
                    }
                )
            ) { entry ->
                MakeDonationScreen(
                    username = entry.arguments?.getString("username"),
                    navController = navController
                )
            }
            composable(
                route = Screen.Confirmation.route+ "/{username}", arguments = listOf(
                    navArgument("username") {
                        type = NavType.StringType
                        defaultValue = "Seby"
                        nullable = true
                    }
                )
            ) { entry ->
                ConfirmationScreen(
                    username = entry.arguments?.getString("username"),
                    navController = navController
                )
            }
            composable(route = Screen.Template.route+ "/{username}", arguments = listOf(
                navArgument("username") {
                    type = NavType.StringType
                    defaultValue = "Seby"
                    nullable = true
                }
            )
            ) { entry ->
                TemplateScreen(
                    username = entry.arguments?.getString("username"),
                    navController = navController
                )
            }
            composable(route = Screen.Portfølje.route+ "/{username}", arguments = listOf(
                navArgument("username") {
                    type = NavType.StringType
                    defaultValue = "Seby"
                    nullable = true
                }
            )
            ) { entry ->
                PortføljeNy(
                    username = entry.arguments?.getString("username"),
                    navController = navController
                )
            }
            composable(route = Screen.BygPortfølje.route+ "/{username}", arguments = listOf(
                navArgument("username") {
                    type = NavType.StringType
                    defaultValue = "Seby"
                    nullable = true
                }
            )
            ) { entry ->
                BygPortfølje(
                    username = entry.arguments?.getString("username"),
                    navController = navController
                )
            }
            composable(route = Screen.Organisation.route+ "/{username}", arguments = listOf(
                navArgument("username") {
                    type = NavType.StringType
                    defaultValue = "Seby"
                    nullable = true
                }
            )) { entry ->
                Organisation(
                    navController = navController,
                    "World Wildlife Fund",
                    orgVM,
                    username = entry.arguments?.getString("username")
                )
            }
            composable(route = Screen.Menu.route+ "/{username}", arguments = listOf(
                navArgument("username") {
                    type = NavType.StringType
                    defaultValue = "Seby"
                    nullable = true
                }
            )
            ) { entry ->
                Menu(
                    username = entry.arguments?.getString("username"),
                    navController = navController
                )
            }
            composable(route = Screen.Sikkerhed.route+ "/{username}", arguments = listOf(
                navArgument("username") {
                    type = NavType.StringType
                    defaultValue = "Seby"
                    nullable = true
                }
            )
            ) { entry ->
                Sikkerhed(
                    username = entry.arguments?.getString("username"),
                    navController = navController
                )
            }
            composable(route = Screen.Miljo.route+ "/{username}", arguments = listOf(
                navArgument("username") {
                    type = NavType.StringType
                    defaultValue = "Seby"
                    nullable = true
                }
            )
            ) { entry ->
                Miljø(
                    username = entry.arguments?.getString("username"),
                    navController = navController
                )
            }
            composable(route = Screen.Sundhed.route+ "/{username}", arguments = listOf(
                navArgument("username") {
                    type = NavType.StringType
                    defaultValue = "Seby"
                    nullable = true
                }
            )
            ) { entry ->
                Sundhed(
                    username = entry.arguments?.getString("username"),
                    navController = navController
                )
            }
            composable(route = Screen.SocialtUdsatte.route+ "/{username}", arguments = listOf(
                navArgument("username") {
                    type = NavType.StringType
                    defaultValue = "Seby"
                    nullable = true
                }
            )
            ) { entry ->
                SocialtUdsatte(
                    username = entry.arguments?.getString("username"),
                    navController = navController
                )
            }
            composable(route = Screen.Dyrevelfærd.route+ "/{username}", arguments = listOf(
                navArgument("username") {
                    type = NavType.StringType
                    defaultValue = "Seby"
                    nullable = true
                }
            )
            ) { entry ->
                Dyrevelfærd(
                    username = entry.arguments?.getString("username"),
                    navController = navController
                )
            }
            composable(route = Screen.Hjælp.route+ "/{username}", arguments = listOf(
                navArgument("username") {
                    type = NavType.StringType
                    defaultValue = "Seby"
                    nullable = true
                }
            )
            ) { entry ->
                Hjælp(
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
                    navController = navController,
                    "World Wildlife Fund",
                    orgVM
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