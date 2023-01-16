package com.example.kind1

import androidx.compose.animation.AnimatedContentScope.SlideDirection.Companion.Start
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement.Start
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Start
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun MakeDonationScreen(navController: NavController, username: String?) {
    Card(elevation = 2.dp) {
        Image(
            contentScale = ContentScale.FillBounds,
            painter = painterResource(id = R.drawable.bekindbackground2),
            contentDescription = null,
            modifier = Modifier.fillMaxSize()
        )

        Column(
            Modifier
                .fillMaxSize()
                .wrapContentSize(Alignment.TopCenter)) {
            Row(Modifier.align(Alignment.Start)){
                Image(painter = painterResource(id = R.drawable.backbutton), contentDescription = null,
                    modifier = Modifier
                        .clickable {
                            navController.navigate(Screen.Organisation.withArgs(username.toString()))
                        }
                        .size(width = 50.dp, height = 30.dp)
                )
            }
            Spacer(modifier = Modifier.height(40.dp))

            Text("Opret donation til [navn]", fontSize = 20.sp, textAlign = TextAlign.Center)
            Spacer(modifier = Modifier.height(40.dp))
            Text("Vælg beløb", fontSize = 15.sp, textAlign = TextAlign.Center)

            AmountTextField()

            Spacer(modifier = Modifier.height(40.dp))
            Row(Modifier.align(Alignment.CenterHorizontally)) {
                CirleButton()
                Spacer(modifier = Modifier.width(60.dp))
                CirleButton()
            }
            Row(Modifier.align(Alignment.CenterHorizontally)) {
                Text(text = "Støt månedligt")
                Spacer(modifier = Modifier.width(60.dp))
                Text("Støt én gang")
            }

            Spacer(modifier = Modifier.height(40.dp))
            NameTextField()
            Spacer(modifier = Modifier.height(10.dp))
            EmailTextField()

            Spacer(modifier = Modifier.height(40.dp))
            SupportButton()
        }
    }
}

@Composable
fun SupportButton() {
    Button(onClick = {
        //navController.navigate(Screen.KindFront.route)
    },
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Yellow),
        modifier = Modifier
            .height(50.dp)
            .width(280.dp)) {
        Text(text = "Støt nu", textAlign = TextAlign.Center,
            color = Color.White,fontWeight = FontWeight.Bold, fontSize = 25.sp
        )
    }
}

@Composable
fun AmountTextField() {
    var value by remember {
        mutableStateOf("")
    }
    TextField(
        value = value, onValueChange = { value = it },
        label = { Text("") }
    )
}

@Composable
fun NameTextField() {
    var user by remember {
        mutableStateOf("")
    }
    TextField(
        value = user, onValueChange = { user = it },
        label = { Text("Dit fulde navn") }

    )
}

@Composable
fun EmailTextField() {
    var email by remember {
        mutableStateOf("")
    }
    TextField(
        value = email, onValueChange = { email = it },
        label = { Text("Din e-mail") }

    )
}

@Composable
fun CirleButton() {
    val color = remember { mutableStateOf(Color.Transparent) }

    OutlinedButton(
        onClick = { color.value = Color.Yellow },
        modifier = Modifier.size(70.dp),
        shape = CircleShape,
        border = BorderStroke(1.dp, Color.Black),
        contentPadding = PaddingValues(0.dp),  //avoid the little icon
        colors = ButtonDefaults.outlinedButtonColors(backgroundColor = color.value)
    ) {
    }
}

