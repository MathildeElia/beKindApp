package com.example.kind1

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun KindSignUp(navController: NavController) {
    val viewmodel = Viewmodel()
    var user by remember {
        mutableStateOf("")
    }
    var pass by remember {
        mutableStateOf("")
    }

    var email by remember {
        mutableStateOf("")
    }

    var wrong by remember {
        mutableStateOf("")
    }

    Column(
        Modifier.fillMaxSize()
    )
    {
        Spacer(modifier = Modifier.height(10.dp))
        Image(painter = painterResource(id = R.drawable.backbutton), contentDescription = null,
        modifier = Modifier
            .clickable {
                navController.navigate(Screen.KindFront.route)
            }
            .size(width = 50.dp, height = 30.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.bekindforside), contentDescription = null,
            modifier = Modifier
                .padding(vertical = 10.dp)
                .align(Alignment.CenterHorizontally)
        )
        Text(
            text = "Sign Up :)",
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Spacer(
            modifier = Modifier
                .height(20.dp)
        )
        TextField(
            value = user, onValueChange = { user = it },
            modifier = Modifier
                .align(Alignment.CenterHorizontally),
            label = { Text("Brugernavn") }

        )
        Spacer(
            modifier = Modifier
                .height(20.dp)
        )

        TextField(
            value = email, onValueChange = { email = it },
            modifier = Modifier
                .align(Alignment.CenterHorizontally),
            label = { Text("Email") }
        )
        Spacer(
            modifier = Modifier
                .height(20.dp)
        )

        TextField(
            value = pass, onValueChange = { pass = it },
            modifier = Modifier
                .align(Alignment.CenterHorizontally),
            label = { Text("Password") }
        )


        Button(
            onClick = {
                if (viewmodel.validInputSign(user, pass,email)) {
                    navController.navigate(Screen.KindStart.withArgs(user))
                }
                wrong = "Remember to input both an username, password and a correct email :)"

            },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(vertical = 10.dp),
        ) {
            Text(text = "Login")
        }
        Text(
            text = wrong,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        )


    }

}