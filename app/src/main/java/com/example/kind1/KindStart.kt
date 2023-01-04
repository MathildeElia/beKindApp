package com.example.kind1

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun KindStart(username: String, navController: NavController) {
    Column {
        Spacer(modifier = Modifier.height(10.dp))
        Image(painter = painterResource(id = R.drawable.backbutton), contentDescription = null,
            modifier = Modifier
                .clickable {
                    navController.navigate(Screen.KindFront.route)
                }
                .size(width = 50.dp, height = 30.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "\t\tHej $username!",
        modifier = Modifier
            ,fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Left,
            fontSize = 25.sp,
            color = Color.White
        )

        Spacer(modifier = Modifier.height(15.dp))

        Text(text = "\t\tDit abonnenement er på plads og ",
            modifier = Modifier,
            fontSize = 25.sp,
            //color = Color(0xFF034A0B),
            color = Color(0xFF315C36)
        )
        Text(text = "\t\tdu er on track til at donere 100 kr.",
            modifier = Modifier,
            fontSize = 25.sp,
            color = Color(0xFF315C36)

        )

        Spacer(modifier = Modifier.height(15.dp))

        Text(text = "\t\tDu er blandt top 1% af donerer denne",
            modifier = Modifier,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = Color.White)


        Text(text = "\t\tmåned. Godt gået!",
            modifier = Modifier,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = Color.White)

        Button(
            onClick = {
                navController.navigate(Screen.MakeDonatinon.withArgs(username))},
            colors = ButtonDefaults.buttonColors
                (backgroundColor =  Color(R.color.darkgreen))
        )
        {
            Text(text = "Donér nu!")
        }


    }
}