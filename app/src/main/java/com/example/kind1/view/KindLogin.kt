@file:JvmName("KindFronKt")

package com.example.kind1

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.kind1.viewlmodel.LoginViewModel
import kotlinx.coroutines.Delay
import kotlinx.coroutines.delay


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
        var email by remember {
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
            Text(
                text = "be Kind",
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF315C36),
                fontSize = 40.sp,
                modifier = Modifier.align(CenterHorizontally)
            )
            Image(
                painter = painterResource(id = R.drawable.logindname), contentDescription = null,
                modifier = Modifier
                    .padding(vertical = 10.dp)
                    .align(CenterHorizontally)
            )
            Text(
                text = "Velkommen tilbage!",
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF315C36),
                modifier = Modifier.align(CenterHorizontally)
            )
            Text(
                text = "Log ind for at fortsætte",
                fontFamily = FontFamily.Serif,
                color = Color(0xFF315C36),
                modifier = Modifier.align(CenterHorizontally)
            )
            Spacer(
                modifier = Modifier
                    .height(20.dp)
            )
            TextField(
                value = email, onValueChange = { email = it },
                modifier = Modifier
                    .align(CenterHorizontally).clip(RoundedCornerShape(12.dp)),
                label = { Text("Email") }

            )
            Spacer(
                modifier = Modifier
                    .height(20.dp)
            )

            TextField(
                value = pass, onValueChange = { pass = it },
                modifier = Modifier
                    .align(CenterHorizontally).clip(RoundedCornerShape(12.dp)),
                label = { Text("Kodeord") }
            )

            Button(
                onClick = {
                    //viewmodel.IsAdmin(navController,email)

                    wrong = viewmodel.login(email,pass,navController)

                },
                modifier = Modifier
                    .align(CenterHorizontally)
                    .padding(vertical = 10.dp),
                elevation=null
                ,colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF315C36))
            ) {
                Text(text = "Log ind",color = Color.White)
            }
            Text(
                text = wrong,
                modifier = Modifier
                    .align(CenterHorizontally).clip(RoundedCornerShape(12.dp))
            )
        }
    }


}

