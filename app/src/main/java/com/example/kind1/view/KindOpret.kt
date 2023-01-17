package com.example.kind1

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.kind1.viewlmodel.SignUpViewModel


@Composable
fun KindSignUp(navController: NavController) {



    Card(elevation = 2.dp) {
        Image(
            contentScale = ContentScale.FillBounds,
            painter = painterResource(id = R.drawable.bekindbackground2),
            contentDescription = null,
            modifier = Modifier.fillMaxSize()
        )
        val viewmodel = Viewmodel()
        val viewmodel2 = SignUpViewModel()
        var user by remember {
            mutableStateOf("")
        }
        var pass by remember {
            mutableStateOf("")
        }

        var email by remember {
            mutableStateOf("")
        }

        var validationFinished by remember {
            mutableStateOf(false)
        }

        var wrong by remember {
            mutableStateOf("")
        }

    Column(
        Modifier.fillMaxSize()
    )
    {
        Spacer(modifier = Modifier.height(10.dp))
        Column(Modifier.fillMaxSize())
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
                text = "Opret Bruger",
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
                label = { Text("Kodeord") }
            )
            Button(
                onClick = {
                    if (viewmodel2.validInputSign(user,pass, email)) {
                        viewmodel2.addToDatabase(user, email)
                        viewmodel2.signUp(email,pass)

                        navController.navigate(Screen.KindStart.withArgs(user))
                    }
                    else if(!viewmodel2.validInputSign(user, pass, email)){
                        wrong = "Husk at fylde både Brugernavn, Kodeord og Email korrekt"
                    }
            },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(vertical = 10.dp),
        ) {
            Text(text = "Opret Bruger")
        }
        Text(
            text = wrong,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        )
            }
            Text(
                text = wrong,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            )
        }
    }
}