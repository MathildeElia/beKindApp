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

@Composable
fun AdminOversigt(navController: NavHostController, username: String?) {
    var numberOfPeople = 1034
    var totalMoney = 62300
    var percentage = 25
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
                            //navController.navigate(Screen.AdminPage.route)
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
                Spacer(modifier = Modifier.height(50.dp))
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
                        .background(Color.White)
                        .padding(horizontal = 10.dp)
                ) {
                    Text(
                        modifier = Modifier
                            .fillMaxSize()
                            .wrapContentSize(),
                        text = "Socialt udsatte $percentage %",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF315C36)
                    )


                }
                Spacer(modifier = Modifier.height(40.dp))
                Box(
                    modifier = Modifier
                        .size(width = 440.dp, height = 60.dp)
                        .clip(shape = RoundedCornerShape(15.dp))
                        .background(Color.White)
                        .padding(horizontal = 10.dp)
                ) {
                    Text(
                        modifier = Modifier
                            .fillMaxSize()
                            .wrapContentSize(),
                        text = "Miljø $percentage %",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF315C36)
                    )


                }
                Spacer(modifier = Modifier.height(40.dp))
                Box(
                    modifier = Modifier
                        .size(width = 440.dp, height = 60.dp)
                        .clip(shape = RoundedCornerShape(15.dp))
                        .background(Color.White)
                        .padding(horizontal = 10.dp)
                ) {
                    Text(
                        modifier = Modifier
                            .fillMaxSize()
                            .wrapContentSize(),
                        text = "Dyrevelfærd $percentage %",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF315C36)
                    )


                }
                Spacer(modifier = Modifier.height(40.dp))
                Box(
                    modifier = Modifier
                        .size(width = 440.dp, height = 60.dp)
                        .clip(shape = RoundedCornerShape(15.dp))
                        .background(Color.White)
                        .padding(horizontal = 10.dp)
                ) {
                    Text(
                        modifier = Modifier
                            .fillMaxSize()
                            .wrapContentSize(),
                        text = "Sundhed $percentage %",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF315C36)
                    )


                }
                Spacer(modifier = Modifier.height(20.dp))




            }
        }
    }
}
