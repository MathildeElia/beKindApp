package com.example.kind1

sealed class Screen(val route : String) {

    object KindFront : Screen("kind_front")
    object KindLogin : Screen("kind_login")
    object KindStart : Screen("kind_start")

    fun withArgs(vararg args : String): String{

        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}