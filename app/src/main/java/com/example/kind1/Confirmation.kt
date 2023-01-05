package com.example.kind1

import android.widget.ToggleButton
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun ConfirmationScreen(navController: NavController){
    Card(elevation = 2.dp) {
        Image(
            contentScale = ContentScale.FillBounds,
            painter = painterResource(id = R.drawable.bekindbackground2),
            contentDescription = null,
            modifier = Modifier.fillMaxSize()
        )
        Column(
            Modifier.fillMaxSize()
                .wrapContentSize(Alignment.TopCenter)
        ) {
            Row(Modifier.align(Alignment.Start)) {
                Image(painter = painterResource(id = R.drawable.backbutton),
                    contentDescription = null,
                    modifier = Modifier
                        .clickable {
                            //navController.navigate(Screen.KindFront.route)
                        }
                        .size(width = 50.dp, height = 30.dp)
                )
            }
            Spacer(modifier = Modifier.height(40.dp))
            Text("Tillykke, du har nu \ndoneret!", fontSize = 25.sp, textAlign = TextAlign.Center)

            Spacer(modifier = Modifier.height(30.dp))
            Text("Tak for din støtte", fontSize = 20.sp, textAlign = TextAlign.Center)

            Spacer(modifier = Modifier.height(10.dp))
            Image(
                painter = painterResource(R.drawable.bekindforside),
                contentDescription = "forside billede"
            )
            Spacer(modifier = Modifier.height(30.dp))
            Text("-> se din portefølje", textAlign = TextAlign.Center)
        }
    }
}