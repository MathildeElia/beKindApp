package com.example.kind1

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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Composable
fun BygPortfølje (modifier: Modifier = Modifier, navController: NavController){
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
            Text(
                text = "\t\tByg din Portfølje",
                modifier = Modifier,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Left,
                fontSize = 30.sp,
                color = Color(0xFF315C36)
            )

            Spacer(modifier = Modifier.height(15.dp))

            Text(
                text = "\t\tVælg så mange temaer som du har lyst ",
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
                        .size(275.dp, 200.dp)
                        .clip(shape)
                        .background(Color.White)
                )
                {
                    Spacer(modifier = Modifier.requiredHeight(32.dp))
                    Text(
                        text = "Socialt Udsatte",
                        modifier = Modifier
                            .padding(15.dp, 15.dp, 0.dp, 0.dp),
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        color = Color(0xFF315C36)
                    )

                    Text(
                        text = "Hjælp de hjemløse og",
                        modifier = Modifier
                            .padding(15.dp, 50.dp, 0.dp, 0.dp),
                        fontSize = 15.sp,
                        color = Color(0xFF315C36)
                    )

                    Text(
                        text = "bostederne i København",
                        modifier = Modifier
                            .padding(15.dp, 70.dp, 0.dp, 0.dp),
                        fontSize = 15.sp,
                        color = Color(0xFF315C36)
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Button(
                        onClick = {
                            navController.navigate(Screen.KindLogin.route)
                        },
                        modifier = Modifier
                            .padding(15.dp, 100.dp, 0.dp, 0.dp),
                        colors = ButtonDefaults.buttonColors
                            (backgroundColor = Color(R.color.darkgreen))
                    ) {
                        Text(stringResource(R.string.log))
                        //Color(R.color.darkgreen)
                    }

                }
            }

        }
    }
}
/*
Button(
onClick = {
    navController.navigate(Screen.KindSignUp.route)
},
colors = ButtonDefaults.buttonColors
(backgroundColor = Color(R.color.darkgreen))
) {
    Text(stringResource(R.string.sign))
}
//

 */