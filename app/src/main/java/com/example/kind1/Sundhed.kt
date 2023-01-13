package com.example.kind1

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
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
//tester om head er resettet....
@Composable
fun Sundhed (modifier: Modifier = Modifier, navController: NavController) {
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
                        navController.navigate(Screen.BygPortfølje.route)
                    }
                    .size(width = 50.dp, height = 30.dp)
            )

            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "\t\tSundhed",
                modifier = Modifier,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                fontSize = 30.sp,
                color = Color(0xFF315C36)
            )

            Spacer(modifier = Modifier.height(15.dp))

            Text(
                text = "\t\t2 Linjers Random Text ",
                modifier = Modifier,
                fontSize = 18.sp,
                //color = Color(0xFF034A0B),
                color = Color(0xFF315C36)
            )

            Text(
                text = "\t\t2 Linjers Random Text.",
                modifier = Modifier,
                fontSize = 18.sp,
                color = Color(0xFF315C36)
            )

            Spacer(modifier = Modifier.height(40.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentSize(Alignment.Center)
            ) {
                Box(
                    modifier = Modifier
                        .size(275.dp, 165.dp)
                        .clip(shape)
                        .background(Color.White)
                )
            }
        }

    }
}
