package com.example.kind1
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun KindBekræftet(navController: NavController) {
    Card(elevation = 2.dp) {
        Image(
            contentScale = ContentScale.FillBounds,
            painter = painterResource(id = R.drawable.bekindbackground2),
            contentDescription = null,
            modifier = Modifier.fillMaxSize()
        )
        Column(
            Modifier
                .fillMaxSize()
                .wrapContentSize(Alignment.TopCenter)


        )

        {
            Row(
                Modifier.align(Alignment.Start)) {
                Image(painter = painterResource(id = R.drawable.backbutton),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(vertical = 5.dp)
                        .clickable {
                            navController.navigate(Screen.MakeDonation.route)
                        }
                        .size(width = 50.dp, height = 30.dp)
                )
                Spacer(modifier = Modifier.width(280.dp))
                
                Image(painter = painterResource(id = R.drawable.menuicon),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(vertical = 5.dp)
                        .clickable {
                            navController.navigate(Screen.Menu.route)
                        }
                        .size(width = 40.dp, height = 20.dp)
                        .wrapContentSize(Alignment.Center)

                )
            }
        }
            Column(
                Modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.TopCenter)
                    .padding(vertical = 70.dp)
                    ) {

                Text("\t\tTillykke, du har nu",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF315C36))
                Text("\t\t\t\t\t\t\t     doneret!",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF315C36)

                )
                    Spacer(modifier = Modifier.height(20.dp))
                    Text("\t\t\t\t\t\t\t   Tak for din støtte.",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF315C36))

                    }
        Column(
            Modifier
                .fillMaxSize()
                .wrapContentSize(Alignment.Center)
                .wrapContentWidth(Alignment.CenterHorizontally)) {


            Image(
                painter = painterResource(R.drawable.bekindforside),
                contentDescription = "forside billede"
            )
        }
            Spacer(modifier = Modifier.height(10.dp))
            Column(Modifier
                .fillMaxSize()
                .wrapContentSize(Alignment.BottomCenter)
                .wrapContentWidth(Alignment.CenterHorizontally)
                .padding(80.dp)) {


            Button(
                onClick = {
                    navController.navigate(Screen.Portfølje.route)
                },
                colors = ButtonDefaults.buttonColors
                    (backgroundColor = Color(0xFF315C36))
            ) {
                Text("-> Se din portefølje" , textAlign = TextAlign.Center , color = Color.White)

            }
        }
                }

        }
