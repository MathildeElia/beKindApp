package com.example.kind1

import androidx.compose.foundation.Image
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun KindFront(modifier: Modifier = Modifier, navController: NavController) {
    Card(elevation = 2.dp) {
        Image(
            contentScale = ContentScale.FillBounds,
            painter = painterResource(id = R.drawable.bekindbackground2),
            contentDescription = null,
            modifier = Modifier.fillMaxSize()

        )

        Column(
            modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Spacer(modifier = Modifier.height(40.dp))

            Image(
                painter = painterResource(R.drawable.bekindtitel),
                contentDescription = "titel",
                modifier = Modifier
                    //.fillMaxWidth(),
                    .size(width = 300.dp, height = 85.dp)
            )
            Spacer(modifier = Modifier.height(15.dp))
            Text(
                text = "Begynd at byg dit personlige portefølje af velgørenhed i dag!",
                fontSize = 19.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.CenterHorizontally)
                    .padding(50.dp, 0.dp, 40.dp, 10.dp)
            )

            Image(
                painter = painterResource(R.drawable.bekindforside),
                contentDescription = "forside billede",
                Modifier
                    .size(width = 300.dp, height = 300.dp)
            )
            Spacer(modifier = Modifier.height(30.dp))

            Row(
                Modifier
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth()
                    .wrapContentWidth()) {
                Button(
                    onClick = {
                        navController.navigate(Screen.KindLogin.route)
                    },
                    modifier = Modifier.size(width = 130.dp, height = 35.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF315C36)),
                    elevation = null
                ) {
                    Text(
                        stringResource(R.string.log),
                        color = Color.White,
                        // modifier = Modifier.clip(RoundedCornerShape(12.dp))
                    )
                }
                Spacer(modifier = Modifier.width(15.dp))
                Button(
                    onClick = {
                        navController.navigate(Screen.KindSignUp.route)
                    },
                    modifier = Modifier.size(width = 130.dp, height = 35.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF315C36)),
                    elevation = null
                ) {
                    Text(
                        stringResource(R.string.sign), color = Color.White
                    )
                }
            }
            Button(
                onClick = {
                    navController.navigate(Screen.Gæst.withArgs("Gæst"))
                },
                colors = ButtonDefaults.buttonColors
                    (backgroundColor = Color.Transparent),
                elevation = null,

                ) {
                Text(
                    stringResource(R.string.senere),
                    style = androidx.compose.ui.text.TextStyle(textDecoration = TextDecoration.Underline),
                    fontSize = 17.sp
                )
            }
        }
    }
}