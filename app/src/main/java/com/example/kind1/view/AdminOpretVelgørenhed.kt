package com.example.kind1.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.kind1.R
import com.example.kind1.Screen
import com.example.kind1.Viewmodel
import com.example.kind1.viewlmodel.VievModelAdmin

@Composable
fun AdminOpretVelgørenhed(navController: NavHostController, username: String?) {
    val viewmodel = VievModelAdmin()

    Card(elevation = 2.dp) {
        Image(
            contentScale = ContentScale.FillBounds,
            painter = painterResource(id = R.drawable.forside),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .fillMaxWidth()
        )
        var charityName by remember {
            mutableStateOf("")
        }
        var charitySubtitle by remember {
            mutableStateOf("")
        }
        var beskrivelse by remember {
            mutableStateOf("")
        }


        Column {
            Spacer(modifier = Modifier.height(5.dp))
            Row {
                Spacer(modifier = Modifier.height(10.dp))
                Image(painter = painterResource(id = R.drawable.backbutton),
                    contentDescription = null,
                    modifier = Modifier
                        .clickable {
                            navController.navigate(Screen.AdminPage.withArgs(username.toString()))
                        }
                        .size(width = 50.dp, height = 30.dp)
                )
                Spacer(modifier = Modifier.width(290.dp))

            }

            Spacer(modifier = Modifier.height(36.dp))
            Text(
                text = "Opret Velgørenhed",
                fontSize = 26.sp,
                fontFamily = FontFamily.Serif,
                color = Color.White,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.CenterHorizontally)
                    .padding(vertical = 14.dp)
            )
            Row(
                modifier = Modifier
                    .size(width = 900.dp, height = 80.dp)
                    //.clip(shape = RoundedCornerShape(15.dp))
                    .background(Color.White)
                    .padding(horizontal = 1.dp)
                    .fillMaxSize()
                    .wrapContentSize()

            ) {

                TextField(value = charityName, onValueChange = { charityName = it },
                    modifier = Modifier,
                    label = { Text("Organisation Navn") }
                )
            }
            Row( modifier = Modifier
                .size(width = 900.dp, height = 80.dp)
                //.clip(shape = RoundedCornerShape(15.dp))
                .background(Color.White)
                .padding(horizontal = 1.dp)
                .fillMaxSize()
                .wrapContentSize()
            ){

                TextField(value = charitySubtitle, onValueChange = {charitySubtitle= it},
                modifier = Modifier,
                    label = {Text("Undertekst")})
            }

            Row(modifier = Modifier
                .size(width = 900.dp, height = 80.dp)
                //.clip(shape = RoundedCornerShape(15.dp))
                .background(Color.White)
                .padding(horizontal = 1.dp)
                .fillMaxSize()
                .wrapContentSize()) {


                TextField(
                    value = beskrivelse, onValueChange = { beskrivelse = it },
                    modifier = Modifier,
                    label = { Text("Beskrivelse") }

                )
            }
            Row(modifier = Modifier
                .size(width = 900.dp, height = 80.dp)
                        //.clip(shape = RoundedCornerShape(15.dp))
                .background(Color.White)
                .padding(horizontal = 1.dp)
                .fillMaxSize()
                .wrapContentSize()
                ) {

                    Button(
                        onClick = {

                            viewmodel.submitCharity(charityName,charitySubtitle,beskrivelse)
                            navController.navigate(Screen.AdminPage.withArgs(username.toString()))

                        },
                        modifier = Modifier
                            .padding(horizontal = 60.dp, vertical = 10.dp)
                            .fillMaxWidth()
                            .wrapContentWidth(Alignment.CenterHorizontally),
                        //, elevation = null,
                            colors = ButtonDefaults.buttonColors
                            (backgroundColor = Color.Transparent)
                    ) {
                        Text(
                            modifier = Modifier
                                .fillMaxSize()
                                .wrapContentSize()
                                .padding(horizontal = 2.dp),
                            text = ">",
                            fontSize = 30.sp,
                            fontFamily = FontFamily.Serif,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF315C36)
                        )
                        //  Divider(startIndent = 8.dp, thickness = 1.dp, color = Color.Black)
                    }
                }
            }
        }
    }


