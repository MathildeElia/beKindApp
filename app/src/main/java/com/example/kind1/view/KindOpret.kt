package com.example.kind1

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
            Text(
                text = "be Kind",
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF315C36),
                fontSize = 40.sp,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Image(
                painter = painterResource(id = R.drawable.logindname), contentDescription = null,
                modifier = Modifier
                    .padding(vertical = 10.dp)
                    .align(Alignment.CenterHorizontally)
            )
            Text(
                text = "Velkommen!",
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF315C36),
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Text(
                text = "Opret bruger for at fortsætte",
                fontFamily = FontFamily.Serif,
                color = Color(0xFF315C36),
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Spacer(
                modifier = Modifier
                    .height(20.dp)
            )
            TextField(
                value = user, onValueChange = { user = it },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally).clip(RoundedCornerShape(12.dp)),
                label = { Text("Brugernavn") }

            )
            Spacer(
                modifier = Modifier
                    .height(20.dp)
            )

            TextField(
                value = email, onValueChange = { email = it },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally).clip(RoundedCornerShape(12.dp)),
                label = { Text("Email") }
            )
            Spacer(
                modifier = Modifier
                    .height(20.dp)
            )

            TextField(
                value = pass, onValueChange = { pass = it },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally).clip(RoundedCornerShape(12.dp)),
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
                elevation=null
                ,colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF315C36))
        ) {
            Text(text = "Opret Bruger", color= Color.White)
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