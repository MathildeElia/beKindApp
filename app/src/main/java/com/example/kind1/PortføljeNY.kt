package com.example.kind1

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun PortføljeNy(navController: NavController){
    var themes = 4
    var charities = 6
    var percentage = 25
    Column(
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
        Spacer(modifier = Modifier.height(2.dp))
        Column(modifier = Modifier.padding(24.dp)) {

            Text("Portfølje", fontSize = 28.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(20.dp))
            Text("Indtil videre støtter du:", fontSize = 15.sp)
            Spacer(modifier = Modifier.height(2.dp))
            Text("- $themes temaer", fontSize = 15.sp)
            Spacer(modifier = Modifier.height(2.dp))
            Text("- $charities velgørenheds-organisationer", fontSize = 15.sp)
            Spacer(modifier = Modifier.height(20.dp))
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
                    .background(Color.Red)
                    .padding(horizontal = 10.dp)
            ){
                Text(modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize()
                    ,
                    text = "Socialt udsatte $percentage %", fontSize = 24.sp , fontWeight = FontWeight.Bold,color = Color.White)


            }
            Spacer(modifier = Modifier.height(40.dp))
            Box(
                modifier = Modifier
                    .size(width = 440.dp, height = 60.dp)
                    .clip(shape = RoundedCornerShape(15.dp))
                    .background(Color.Red)
                    .padding(horizontal = 10.dp)
            ){
                Text(modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize()
                    ,
                    text = "Miljø $percentage %", fontSize = 24.sp , fontWeight = FontWeight.Bold,color = Color.White)


            }
            Spacer(modifier = Modifier.height(40.dp))
            Box(
                modifier = Modifier
                    .size(width = 440.dp, height = 60.dp)
                    .clip(shape = RoundedCornerShape(15.dp))
                    .background(Color.Red)
                    .padding(horizontal = 10.dp)
            ){
                Text(modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize()
                    ,
                    text = "Dyrevelfærd $percentage %", fontSize = 24.sp , fontWeight = FontWeight.Bold,color = Color.White)


            }
            Spacer(modifier = Modifier.height(40.dp))
            Box(
                modifier = Modifier
                    .size(width = 440.dp, height = 60.dp)
                    .clip(shape = RoundedCornerShape(15.dp))
                    .background(Color.Red)
                    .padding(horizontal = 10.dp)
            ){
                Text(modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize()
                    ,
                    text = "Sundhed $percentage %", fontSize = 24.sp , fontWeight = FontWeight.Bold,color = Color.White)


            }
            Spacer(modifier = Modifier.height(100.dp))
            //StøtMereButton()



        }
    }
}
/*
@Composable
fun StøtMereButton() {
    Button(onClick = {
        //navController.navigate(Screen.KindMakeDonation.route)
    },
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Green),
        modifier = Modifier.padding(60.dp)
            .wrapContentSize()
            .height(80.dp)
            .width(200.dp)) {
        Text(text = "Støt mere", textAlign = TextAlign.Center,
            color = Color.White,fontWeight = FontWeight.Bold, fontSize = 25.sp
        )
    }
}

    }
}
 */
