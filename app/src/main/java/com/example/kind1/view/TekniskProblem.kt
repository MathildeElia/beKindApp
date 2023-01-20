package com.example.kind1

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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.kind1.viewlmodel.VMTekniskProblem

@Composable
fun TekniskProblem(username: String?, navController: NavHostController) {
    val viewmodel = VMTekniskProblem()

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
                        .padding(20.dp, 5.dp, 0.dp, 10.dp)
                        .clickable {
                            navController.navigate(Screen.Menu.withArgs(username.toString()))
                        }
                        .size(width = 40.dp, height = 20.dp)
                        .wrapContentSize(Alignment.TopEnd)
                )
            }

            Spacer(modifier = Modifier.height(36.dp))
            Text(
                text = "Rapportér et teknisk problem",
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

            ){
                var report by remember {
                    mutableStateOf("")
                }
                TextField(
                    value = report, onValueChange = { report = it },
                    modifier = Modifier,
                    label = { Text("Rapport") }

                )

            Box(
                modifier = Modifier
                    .size(width = 300.dp, height = 60.dp)
                    //.clip(shape = RoundedCornerShape(15.dp))
                    .background(Color.White)
                    .padding(horizontal = 10.dp)

            ) {

                Button(
                    onClick = {
                            viewmodel.submitError(report,username.toString())
                            navController.navigate(Screen.MinKonto.withArgs(username.toString()))

                    },
                    modifier = Modifier
                    //  .fillMaxWidth()
                    //  .wrapContentWidth(Alignment.Start),
                    //, elevation = null,
                    , colors = ButtonDefaults.buttonColors
                        (backgroundColor = Color.Transparent)
                ) {
                    Text(
                        modifier = Modifier
                            .fillMaxSize()
                            .wrapContentSize()
                            .padding(2.dp),
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
}
