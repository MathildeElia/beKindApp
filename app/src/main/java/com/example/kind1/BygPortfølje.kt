package com.example.kind1

import androidx.compose.foundation.*
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
        Image(painter = painterResource(id = R.drawable.backbutton), contentDescription = null,
            modifier = Modifier
                .clickable {
                    navController.navigate(Screen.Portfølje.route)
                }
                .size(width = 50.dp, height = 30.dp)
        )
        Column (modifier = Modifier.verticalScroll(rememberScrollState())){
            val shape = RoundedCornerShape(12.dp)
            Spacer(modifier = Modifier.height(10.dp))
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
                        .size(275.dp, 165.dp)
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

                    Button(
                        onClick = {
                            navController.navigate(Screen.Template.route)
                        },
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF315C36)),
                        modifier = Modifier
                            .padding(15.dp, 100.dp, 0.dp, 0.dp)
                            .wrapContentSize())
                        {
                            Text("Tilføj Tema",
                            textAlign = TextAlign.Center,
                            color = Color.White,
                            fontSize = 12.sp)
                    }

                    Button(
                        onClick = {
                            navController.navigate(Screen.Template.route)
                        },
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF315C36)),
                        modifier = Modifier
                            .padding(150.dp, 100.dp, 0.dp, 0.dp)
                            .wrapContentSize())
                    {
                        Text(" Læs mere ",
                            textAlign = TextAlign.Center,
                            color = Color.White,
                            fontSize = 12.sp)
                    }

                }
                Spacer(modifier = Modifier.height(40.dp))
                //Second White box
                Box(
                    modifier = Modifier
                        .size(275.dp, 165.dp)
                        .clip(shape)
                        .background(Color.White)
                )
                {
                    Spacer(modifier = Modifier.requiredHeight(32.dp))
                    Text(
                        text = "Sundhed",
                        modifier = Modifier
                            .padding(15.dp, 15.dp, 0.dp, 0.dp),
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        color = Color(0xFF315C36)
                    )

                    Text(
                        text = "Hjælp udsatte med",
                        modifier = Modifier
                            .padding(15.dp, 50.dp, 0.dp, 0.dp),
                        fontSize = 15.sp,
                        color = Color(0xFF315C36)
                    )

                    Text(
                        text = "pykiske problemer",
                        modifier = Modifier
                            .padding(15.dp, 70.dp, 0.dp, 0.dp),
                        fontSize = 15.sp,
                        color = Color(0xFF315C36)
                    )

                    Button(
                        onClick = {
                            navController.navigate(Screen.Template.route)
                        },
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF315C36)),
                        modifier = Modifier
                            .padding(15.dp, 100.dp, 0.dp, 0.dp)
                            .wrapContentSize())
                    {
                        Text("Tilføj Tema",
                            textAlign = TextAlign.Center,
                            color = Color.White,
                            fontSize = 12.sp)
                    }

                    Button(
                        onClick = {
                            navController.navigate(Screen.Template.route)
                        },
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF315C36)),
                        modifier = Modifier
                            .padding(150.dp, 100.dp, 0.dp, 0.dp)
                            .wrapContentSize())
                    {
                        Text(" Læs mere ",
                            textAlign = TextAlign.Center,
                            color = Color.White,
                            fontSize = 12.sp)
                    }

                }
                Spacer(modifier = Modifier.height(40.dp))
                //Third White Box
                Box(
                    modifier = Modifier
                        .size(275.dp, 165.dp)
                        .clip(shape)
                        .background(Color.White)
                )
                {
                    Spacer(modifier = Modifier.requiredHeight(32.dp))
                    Text(
                        text = "Miljø",
                        modifier = Modifier
                            .padding(15.dp, 15.dp, 0.dp, 0.dp),
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        color = Color(0xFF315C36)
                    )

                    Text(
                        text = "Hjælp med at give vores",
                        modifier = Modifier
                            .padding(15.dp, 50.dp, 0.dp, 0.dp),
                        fontSize = 15.sp,
                        color = Color(0xFF315C36)
                    )

                    Text(
                        text = "natur en gave",
                        modifier = Modifier
                            .padding(15.dp, 70.dp, 0.dp, 0.dp),
                        fontSize = 15.sp,
                        color = Color(0xFF315C36)
                    )

                    Button(
                        onClick = {
                            navController.navigate(Screen.Template.route)
                        },
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF315C36)),
                        modifier = Modifier
                            .padding(15.dp, 100.dp, 0.dp, 0.dp)
                            .wrapContentSize()
                    )
                    {
                        Text(
                            "Tilføj Tema",
                            textAlign = TextAlign.Center,
                            color = Color.White,
                            fontSize = 12.sp
                        )
                    }

                    Button(
                        onClick = {
                            navController.navigate(Screen.Template.route)
                        },
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF315C36)),
                        modifier = Modifier
                            .padding(150.dp, 100.dp, 0.dp, 0.dp)
                            .wrapContentSize()
                    )
                    {
                        Text(
                            " Læs mere ",
                            textAlign = TextAlign.Center,
                            color = Color.White,
                            fontSize = 12.sp
                        )
                    }
                }
                Spacer(modifier = Modifier.height(40.dp))
                //Forth White Box
                Box(
                    modifier = Modifier
                        .size(275.dp, 165.dp)
                        .clip(shape)
                        .background(Color.White)
                )
                {
                    Spacer(modifier = Modifier.requiredHeight(32.dp))
                    Text(
                        text = "Dyrevelfærd",
                        modifier = Modifier
                            .padding(15.dp, 15.dp, 0.dp, 0.dp),
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        color = Color(0xFF315C36)
                    )

                    Text(
                        text = "Hjælp med at give vores",
                        modifier = Modifier
                            .padding(15.dp, 50.dp, 0.dp, 0.dp),
                        fontSize = 15.sp,
                        color = Color(0xFF315C36)
                    )

                    Text(
                        text = "natur en gave",
                        modifier = Modifier
                            .padding(15.dp, 70.dp, 0.dp, 0.dp),
                        fontSize = 15.sp,
                        color = Color(0xFF315C36)
                    )

                    Button(
                        onClick = {
                            navController.navigate(Screen.Template.route)
                        },
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF315C36)),
                        modifier = Modifier
                            .padding(15.dp, 100.dp, 0.dp, 0.dp)
                            .wrapContentSize()
                    )
                    {
                        Text(
                            "Tilføj Tema",
                            textAlign = TextAlign.Center,
                            color = Color.White,
                            fontSize = 12.sp
                        )
                    }

                    Button(
                        onClick = {
                            navController.navigate(Screen.Template.route)
                        },
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF315C36)),
                        modifier = Modifier
                            .padding(150.dp, 100.dp, 0.dp, 0.dp)
                            .wrapContentSize()
                    )
                    {
                        Text(
                            " Læs mere ",
                            textAlign = TextAlign.Center,
                            color = Color.White,
                            fontSize = 12.sp
                        )
                    }
                }

            }
            Spacer(modifier = Modifier.height(200.dp))
            Text(
                " Læs mere ",
                textAlign = TextAlign.Center,
                color = Color.White,
                fontSize = 12.sp
            )

        }
    }
}
