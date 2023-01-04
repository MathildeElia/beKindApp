package com.example.kind1

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun ConfirmationScreen(navController: NavController, value: String?, username: String){
    Column(
        Modifier.fillMaxSize()
            .wrapContentSize(Alignment.TopCenter)
    ) {
        Image(painter = painterResource(id = R.drawable.backbutton), contentDescription = null,
            modifier = Modifier
                .clickable {
                    navController.navigate(Screen.MakeDonatinon.withArgs(username))
                }
                .size(width = 50.dp, height = 30.dp)
        )
        Row(Modifier.align(Alignment.Start)){
        }
        Spacer(modifier = Modifier.height(40.dp))
        Text("Tillykke $username, du har nu \ndoneret $value dkk!", fontSize = 25.sp, textAlign = TextAlign.Center)

        Spacer(modifier = Modifier.height(30.dp))
        Text("Tak for din støtte",fontSize = 20.sp, textAlign = TextAlign.Center)

        Spacer(modifier = Modifier.height(10.dp))
        Image(
            painter = painterResource(R.drawable.bekindforside),
            contentDescription = "forside billede"
        )
        Spacer(modifier = Modifier.height(30.dp))
        Text("-> se din portefølje", textAlign = TextAlign.Center,

        )
    }
}