@file:JvmName("KindFronKt")

package com.example.kind1

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.kind1.viewlmodel.LoginViewModel


@Composable
fun KindLogin(navController: NavController) {
    Card(elevation = 2.dp) {
        Image(
            contentScale = ContentScale.FillBounds,
            painter = painterResource(id = R.drawable.bekindbackground2),
            contentDescription = null,
            modifier = Modifier.fillMaxSize()
        )

        val viewmodel = LoginViewModel()
        var user by remember {
            mutableStateOf("")
        }
        var pass by remember {
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
                    .align(CenterHorizontally)
            )
            Text(
                text = "Log ind",
                modifier = Modifier.align(CenterHorizontally)
            )
            Spacer(
                modifier = Modifier
                    .height(20.dp)
            )
            TextField(
                value = user, onValueChange = { user = it },
                modifier = Modifier
                    .align(CenterHorizontally),
                label = { Text("Brugernavn") }

            )
            Spacer(
                modifier = Modifier
                    .height(20.dp)
            )

            TextField(
                value = pass, onValueChange = { pass = it },
                modifier = Modifier
                    .align(CenterHorizontally),
                label = { Text("Kodeord") }
            )

            Button(
                onClick = {
                    wrong = viewmodel.login(user,pass,navController)
                },
                modifier = Modifier
                    .align(CenterHorizontally)
                    .padding(vertical = 10.dp),
            ) {
                Text(text = "Log ind")
            }
            Text(
                text = wrong,
                modifier = Modifier
                    .align(CenterHorizontally)
            )
        }
    }


}

