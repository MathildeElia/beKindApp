package com.example.kind1

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun MinKonto(/*modifier: Modifier = Modifier, navController: NavController*/)

{
    Column (
        Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.TopCenter)) {
        Row(Modifier.align(Alignment.Start)){
            Image(painter = painterResource(id = R.drawable.backbutton), contentDescription = null,
                modifier = Modifier
                    .clickable {
                        //navController.navigate(Screen.KindFront.route)
                    }
                    .size(width = 50.dp, height = 30.dp)
            )
        }

        Text(
            text = text2,
            fontSize = 24.sp,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.Start)

        )

        Text(
            text = text3,
            fontSize = 18.sp,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.Start)
        )

        /*
        Image(
            painter = painterResource(R.drawable.bekindforside),
            contentDescription = "forside billede"
            )
         */

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            //navController.navigate(Screen.KindLogin.route)

        },modifier = Modifier.width(250.dp),
            colors = ButtonDefaults.buttonColors
                (backgroundColor =  Color(R.color.palegreen))){
            Text(stringResource(R.string.kommende))

            //Color(R.color.darkgreen)
        }
        Button(onClick = {
           // navController.navigate(Screen.KindSignUp.route)
        }, modifier = Modifier.width(250.dp),
            colors = ButtonDefaults.buttonColors
                (backgroundColor =  Color(R.color.darkgreen))){
            Text(stringResource(R.string.tidligere))
        }
        Button(onClick = {
           // navController.navigate(Screen.KindStart.withArgs("Gæst"))
        },modifier = Modifier.width(250.dp),
            colors = ButtonDefaults.buttonColors
                (backgroundColor =  Color(R.color.darkgreen)) ){
            Text(stringResource(R.string.oplysninger))
        }
        Button(onClick = {
            // navController.navigate(Screen.KindStart.withArgs("Gæst"))
        },modifier = Modifier.width(250.dp),
            colors = ButtonDefaults.buttonColors
                (backgroundColor =  Color(R.color.darkgreen)) ){
            Text(stringResource(R.string.notifikationer))
        }
        Button(onClick = {
            // navController.navigate(Screen.KindStart.withArgs("Gæst"))
        },modifier = Modifier.width(250.dp),
            colors = ButtonDefaults.buttonColors
                (backgroundColor =  Color(R.color.darkgreen)) ){
            Text(stringResource(R.string.sikkerhed))
        }
        Button(onClick = {
            // navController.navigate(Screen.KindStart.withArgs("Gæst"))
        },modifier = Modifier.width(250.dp),
            colors = ButtonDefaults.buttonColors
                (backgroundColor =  Color(R.color.darkgreen)) ){
            Text(stringResource(R.string.hjælp))
        }
        Button(onClick = {
            // navController.navigate(Screen.KindStart.withArgs("Gæst"))
        },modifier = Modifier.width(250.dp),
            colors = ButtonDefaults.buttonColors
                (backgroundColor =  Color(R.color.darkgreen)) ){
            Text(stringResource(R.string.problem))
        }
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            // navController.navigate(Screen.KindStart.withArgs("Gæst"))
        },modifier = Modifier.width(250.dp),
            colors = ButtonDefaults.buttonColors
                (backgroundColor =  Color(R.color.darkgreen)) ){
            Text(stringResource(R.string.logaf))
        }
    }
}
@Preview
    (showBackground = true)
@Composable
fun MinKontoPreview() {
    MinKonto()
}
