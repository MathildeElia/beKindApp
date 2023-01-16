package com.example.kind1

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun Sikkerhed(modifier: Modifier = Modifier, navController: NavController, username: String?) {
    Card(elevation = 2.dp) {
        Image(
            contentScale = ContentScale.FillBounds,
            painter = painterResource(id = R.drawable.forside),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .fillMaxWidth()
        )

        Column {
            Spacer(modifier = Modifier.height(5.dp))
            Row {
                Spacer(modifier = Modifier.height(10.dp))
                Image(painter = painterResource(id = R.drawable.backbutton),
                    contentDescription = null,
                    modifier = Modifier
                        .clickable {
                            navController.navigate(Screen.MinKonto.withArgs(username.toString()))
                        }
                        .size(width = 50.dp, height = 30.dp)
                )
                Spacer(modifier = Modifier.width(290.dp))
                Image(painter = painterResource(id = R.drawable.menuicon),
                    contentDescription = null,
                    modifier = Modifier
                        .clickable {
                            navController.navigate(Screen.Menu.withArgs(username.toString()))
                        }
                        .size(width = 40.dp, height = 20.dp)
                        .wrapContentSize(Alignment.TopEnd)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Sikkerhed",
                fontSize = 40.sp,
                fontFamily = FontFamily.Serif,
                color = Color.White,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(16.dp))
            Box(
                modifier = Modifier
                    .background(Color.White)
                    .padding(horizontal = 10.dp)
            ) {
                Button(
                    onClick = {
                        // navController.navigate(Screen.KindStart.withArgs("Gæst"))
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentWidth(),
                    colors = ButtonDefaults.buttonColors
                        (backgroundColor = Color.Transparent)
                ) {
                    Column {
                        Text(
                            modifier = Modifier
                                .wrapContentSize()
                            .padding(10.dp, 0.dp, 0.dp, 0.dp),
                            text = "Adgangskode                >",
                            fontSize = 24.sp,
                            fontFamily = FontFamily.Serif,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF315C36)

                        )
                        Divider(startIndent = 8.dp, thickness = 1.dp, color = Color.Black)
                        Text(
                            modifier = Modifier
                                .wrapContentSize()
                                .padding(10.dp, 10.dp, 0.dp, 0.dp),
                            text = "Skift adgangskode",
                            fontSize = 20.sp,
                            fontFamily = FontFamily.Serif,
                            color = Color.Gray
                        )
                    }
                }
            }
            Box(
                modifier = Modifier
                    .background(Color.White)
                    .padding(horizontal = 10.dp)
            ) {
                Button(
                    onClick = {
                        // navController.navigate(Screen.KindStart.withArgs("Gæst"))
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentWidth(),
                    colors = ButtonDefaults.buttonColors
                        (backgroundColor = Color.Transparent)
                ) {
                    Column {
                        Text(
                            modifier = Modifier
                                .wrapContentSize()
                                .padding(10.dp, 0.dp, 0.dp, 0.dp),
                            text = "Totrinsgodkendelse    >",
                            fontSize = 24.sp,
                            fontFamily = FontFamily.Serif,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF315C36)
                        )
                        Divider(startIndent = 8.dp, thickness = 1.dp, color = Color.Black)
                        Text(
                            modifier = Modifier
                                .wrapContentSize()
                                .padding(10.dp, 10.dp, 0.dp, 0.dp),
                            text = "Tilføj ekstra beskyttelse til din konto",
                            fontSize = 20.sp,
                            fontFamily = FontFamily.Serif,
                            color = Color.Gray
                        )
                    }
                }
            }
            Box(
                modifier = Modifier
                    .background(Color.White)
                    .padding(horizontal = 10.dp)
            ) {
                Button(
                    onClick = {
                        // navController.navigate(Screen.KindStart.withArgs("Gæst"))
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentWidth(),
                    colors = ButtonDefaults.buttonColors
                        (backgroundColor = Color.Transparent)
                ) {
                    Column {
                        Text(
                            modifier = Modifier
                                .wrapContentSize()
                                .padding(10.dp, 0.dp, 0.dp, 0.dp),
                            text = "Loginaktivitet              >",
                            fontSize = 24.sp,
                            fontFamily = FontFamily.Serif,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF315C36)
                        )
                        Divider(startIndent = 8.dp, thickness = 1.dp, color = Color.Black)
                        Text(
                            modifier = Modifier
                                .wrapContentSize()
                                .padding(10.dp, 10.dp, 0.dp, 0.dp),
                            text = "Se hvor du er logget på",
                            fontSize = 20.sp,
                            fontFamily = FontFamily.Serif,
                            color = Color.Gray
                        )
                    }
                }
            }

        }
    }
}