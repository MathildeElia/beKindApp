package com.example.kind1.view

import com.example.kind1.R
import com.example.kind1.Screen


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun AdminPage(
    //modifier: Modifier = Modifier, navController: NavController, username: String?
    ){
//id:String
    Card(elevation = 2.dp) {
        Image(
            contentScale = ContentScale.FillBounds,
            painter = painterResource(id = R.drawable.forside),
            contentDescription = null,
            modifier = Modifier.fillMaxSize()
        )

        Column {
            Spacer(modifier = Modifier.height(5.dp))
            Row {
                val shape = RoundedCornerShape(12.dp)
                Spacer(modifier = Modifier.height(10.dp))
                Image(painter = painterResource(id = R.drawable.backbutton),
                    contentDescription = null,
                    modifier = Modifier
                        .clickable {
                            //navController.navigate(Screen.Menu.withArgs(username.toString()))
                        }
                        .size(width = 50.dp, height = 30.dp)
                )
                Spacer(modifier = Modifier.width(290.dp))

            }
            //Min konto og brugernavn
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Menu",
                fontSize = 40.sp,
                fontFamily = FontFamily.Serif,
                color = Color.White,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.Start)
            )

            Text(
                text = "Admin",
                //username.toString(),
                fontSize = 20.sp,
                fontFamily = FontFamily.Serif,
                color = Color.White,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.Start)
            )

            //listen af muligheder ved min konto
            Spacer(modifier = Modifier.height(30.dp))
            Box(
                modifier = Modifier
                    .size(width = 400.dp, height = 60.dp)
                    //.clip(shape = RoundedCornerShape(15.dp))
                    .background(Color.White)
                    .padding(horizontal = 10.dp)
            ){
                Button(
                    onClick = {
                        //navController.navigate(Screen.KindSignUp.route)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentWidth(Alignment.Start),
                    elevation = null,
                    colors = ButtonDefaults.buttonColors
                        (backgroundColor = Color.Transparent)
                ) {
                    Row(horizontalArrangement = Arrangement.Start) {
                        Image(
                            painter = painterResource(R.drawable.ikon2),
                            contentDescription = "ikon2",
                            modifier = Modifier
                                .size(width = 50.dp, height = 30.dp)
                            // .wrapContentWidth(Alignment.Start)
                        )
                        Text(
                            "Donationer/oversigt",
                            fontSize = 18.sp,
                            fontFamily = FontFamily.Serif
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            Box(
                modifier = Modifier
                    .size(width = 400.dp, height = 60.dp)
                    //.clip(shape = RoundedCornerShape(15.dp))
                    .background(Color.White)
                    .padding(horizontal = 10.dp)
            ) {
                Button(
                    onClick = {
                       // navController.navigate(Screen.Hjælp.withArgs(username.toString()))
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentWidth(Alignment.Start),
                    elevation = null,
                    colors = ButtonDefaults.buttonColors
                        (backgroundColor = Color.Transparent)
                ) {
                    Image(
                        painter = painterResource(R.drawable.ikon6),
                        contentDescription = "ikon6",
                        modifier = Modifier.size(width = 50.dp, height = 30.dp)
                    )
                    Text(
                        "Opret ny velgørenhed",
                        fontSize = 18.sp,
                        fontFamily = FontFamily.Serif
                    )
                }
            }
            Box(
                modifier = Modifier
                    .size(width = 400.dp, height = 60.dp)
                    //.clip(shape = RoundedCornerShape(15.dp))
                    .background(Color.White)
                    .padding(horizontal = 10.dp)
            ) {
                Button(
                    onClick = {
                       // navController.navigate(Screen.TekniskProblem.withArgs(username.toString()))
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentWidth(Alignment.Start),
                    elevation = null,
                    colors = ButtonDefaults.buttonColors
                        (backgroundColor = Color.Transparent)
                ) {
                    Image(
                        painter = painterResource(R.drawable.ikon7),
                        contentDescription = "ikon7",
                        modifier = Modifier.size(width = 50.dp, height = 30.dp)
                    )
                    Text(
                        text = "l",
                        fontSize = 18.sp,
                        fontFamily = FontFamily.Serif
                    )
                }
            }
            Spacer(modifier = Modifier.height(35.dp))
            Box(
                modifier = Modifier
                    .size(width = 400.dp, height = 60.dp)
                    //.clip(shape = RoundedCornerShape(15.dp))
                    .background(Color.White)
                    .padding(horizontal = 10.dp)
            ) {
                Button(
                    onClick = {
                       // navController.navigate(Screen.KindFront.route)
                    }, modifier = Modifier.fillMaxWidth(), elevation = null,
                    colors = ButtonDefaults.buttonColors
                        (backgroundColor = Color.Transparent)
                ) {
                    Text(
                        stringResource(R.string.logaf),
                        textAlign = TextAlign.Left,
                        fontSize = 18.sp,
                        fontFamily = FontFamily.Serif
                    )
                }
            }
        }
    }
}

@Preview
    (showBackground = true)
@Composable
fun AdminPagePre(){
    AdminPage()
}
