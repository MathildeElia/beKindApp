package com.example.kind1
//Nu testes der

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun PortføljeNy(navController: NavController) {
    var themes = 4
    var charities = 6
    var percentage = 25
    Card(elevation = 2.dp) {
        Image(
            contentScale = ContentScale.FillBounds,
            painter = painterResource(id = R.drawable.bekindbackground),
            contentDescription = null,
            modifier = Modifier.fillMaxSize()
        )
    Column {
        val shape = RoundedCornerShape(12.dp)
        Spacer(modifier = Modifier.height(10.dp))
        Image(painter = painterResource(id = R.drawable.backbutton), contentDescription = null,
            modifier = Modifier
                .clickable {
                    navController.navigate(Screen.KindFront.route)
                }
                .size(width = 50.dp, height = 30.dp)
        )

        Spacer(modifier = Modifier.height(10.dp))
        Column(modifier = Modifier.padding(10.dp)) {

            Text(
                "\t\tPortefølje",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF315C36)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text("Indtil videre støtter du:", fontSize = 18.sp, color = Color(0xFF315C36))
            Spacer(modifier = Modifier.height(2.dp))
            Text("\t\t- $themes temaer", fontSize = 18.sp, color = Color(0xFF315C36))
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                "\t\t- $charities velgørenheds-organisationer",
                fontSize = 18.sp,
                color = Color(0xFF315C36)
            )
            Spacer(modifier = Modifier.height(50.dp))
        }

        Column(
            modifier = Modifier
                .padding(horizontal = 40.dp)
                .fillMaxWidth()

        ) {
            Box(
                modifier = Modifier
                    .size(width = 440.dp, height = 60.dp)
                    .clip(shape = RoundedCornerShape(15.dp))
                    .background(Color.White)
                    .padding(horizontal = 10.dp)
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentSize(),
                    text = "Socialt udsatte $percentage %",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF315C36)
                )


            }
            Spacer(modifier = Modifier.height(40.dp))
            Box(
                modifier = Modifier
                    .size(width = 440.dp, height = 60.dp)
                    .clip(shape = RoundedCornerShape(15.dp))
                    .background(Color.White)
                    .padding(horizontal = 10.dp)
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentSize(),
                    text = "Miljø $percentage %",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF315C36)
                )


            }
            Spacer(modifier = Modifier.height(40.dp))
            Box(
                modifier = Modifier
                    .size(width = 440.dp, height = 60.dp)
                    .clip(shape = RoundedCornerShape(15.dp))
                    .background(Color.White)
                    .padding(horizontal = 10.dp)
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentSize(),
                    text = "Dyrevelfærd $percentage %",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF315C36)
                )


            }
            Spacer(modifier = Modifier.height(40.dp))
            Box(
                modifier = Modifier
                    .size(width = 440.dp, height = 60.dp)
                    .clip(shape = RoundedCornerShape(15.dp))
                    .background(Color.White)
                    .padding(horizontal = 10.dp)
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentSize(),
                    text = "Sundhed $percentage %",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF315C36)
                )


            }
            Spacer(modifier = Modifier.height(20.dp))
            StøtMereButton(navController)


        }
    }
    }
}

@Composable
fun StøtMereButton(navController:NavController) {
    Button(onClick = {
        navController.navigate(Screen.BygPortfølje.route)
    },
        colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF315C36)),
        modifier = Modifier.padding(60.dp)
            .wrapContentSize()
            .height(80.dp)
            .width(200.dp)) {
        Text(text = "Støt mere", textAlign = TextAlign.Center,
            color = Color.White,fontWeight = FontWeight.Bold, fontSize = 25.sp
        )
    }
}





