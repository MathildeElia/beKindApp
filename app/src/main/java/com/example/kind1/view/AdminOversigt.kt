package com.example.kind1.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kind1.R
import androidx.navigation.NavHostController
import com.example.kind1.Screen

@Composable
fun AdminOversigt(navController: NavHostController, username: String?) {
    var numberOfPeople = 134
    var totalMoney = 6230
    var percentage = 8

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
            Row{
                Spacer(modifier = Modifier.height(10.dp))
                Image(painter = painterResource(id = R.drawable.backbutton), contentDescription = null,
                    modifier = Modifier
                        .clickable {
                            navController.navigate(Screen.AdminPage.withArgs(username.toString()))
                        }
                        .size(width = 50.dp, height = 30.dp)
                )

                Spacer(modifier = Modifier.width(290.dp))

            }

            Spacer(modifier = Modifier.height(10.dp))
            Column(modifier = Modifier.padding(10.dp)) {

                Text(
                    "\t\tOversigt",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF315C36)
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text("\t\tIndtil videre støtter :", fontSize = 18.sp, color = Color(0xFF315C36))
                Spacer(modifier = Modifier.height(2.dp))
                Text("\t\t- $numberOfPeople mennesker", fontSize = 18.sp, color = Color(0xFF315C36))
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    "\t\t- $totalMoney kr.",
                    fontSize = 18.sp,
                    color = Color(0xFF315C36)
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    "\t\tDin organisation.",
                    fontSize = 18.sp,
                    color = Color(0xFF315C36)
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    "\t\tDet svarer til $percentage % af antallet af samlede donationer.",
                    fontSize = 18.sp,
                    color = Color(0xFF315C36)
                )

                Spacer(modifier = Modifier.height(50.dp))
            }





            }
        }
    }
