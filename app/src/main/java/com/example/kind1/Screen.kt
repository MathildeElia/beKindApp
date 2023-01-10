package com.example.kind1

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

sealed class Screen(val route : String) {
    object KindFront : Screen("kind_front")
    object KindLogin : Screen("kind_login")
    object KindStart : Screen("kind_start")
    object KindSignUp: Screen("kind_signup")
    object MakeDonatinon : Screen("make_donation")
    object Confirmation : Screen("confirmation")
    object MinKonto : Screen ("MinKonto")
    object Template : Screen("template")
    object Portfølje : Screen("portfølje")
    object Organisation : Screen("organisation")


    fun withArgs(vararg args : String): String{

        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}