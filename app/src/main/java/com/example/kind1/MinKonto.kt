package com.example.kind1

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import com.example.kind1.ui.theme.DarkGreen

@Composable
fun MinKonto(modifier: Modifier = Modifier, navController: NavController) {
    Image(
        contentScale = ContentScale.FillBounds,
        painter = painterResource(id = R.drawable.img),
        contentDescription = null,
        modifier = Modifier.fillMaxSize()
    )

    Column {
        Spacer(modifier = Modifier.height(5.dp))
        Row {
            val shape = RoundedCornerShape(12.dp)
            Spacer(modifier = Modifier.height(10.dp))
            Image(painter = painterResource(id = R.drawable.backbutton), contentDescription = null,
                modifier = Modifier
                    .clickable {
                        navController.navigate(Screen.KindFront.route)
                    }
                    .size(width = 50.dp, height = 30.dp)
            )
            Spacer(modifier = Modifier.width(290.dp))
            Image(painter = painterResource(id = R.drawable.menuicon), contentDescription = null,
                modifier = Modifier
                    .clickable {
                        navController.navigate(Screen.KindFront.route)
                    }
                    .size(width = 40.dp, height = 20.dp)
                    .wrapContentSize(Alignment.TopEnd)
            )
        }
        //Min konto og brugernavn
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = text2,
                fontSize = 40.sp,
                fontFamily = FontFamily.Serif,
                color = Color.White,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.Start)
            )

            Text(
                text = text3,
                fontSize = 20.sp,
                fontFamily = FontFamily.Serif,
                color = Color.White,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.Start)
            )

        //listen af muligheder ved min konto
            Spacer(modifier = Modifier.height(50.dp))
            Button(
                onClick = {
                    navController.navigate(Screen.KindLogin.route)

                }, modifier = Modifier.fillMaxWidth(), elevation = null,
                colors = ButtonDefaults.buttonColors
                    (backgroundColor = Color.Transparent)
            ) {
                Image(
                    painter = painterResource(R.drawable.ikon1),
                    contentDescription = "ikon1",
                    modifier = Modifier.size(width = 50.dp, height = 30.dp)
                )

                Text(
                    stringResource(R.string.kommende),
                    textAlign = TextAlign.Left,
                    fontSize = 18.sp,
                    fontFamily = FontFamily.Serif
                )

            }

            Button(
                onClick = {
                    navController.navigate(Screen.KindSignUp.route)
                }, modifier = Modifier.fillMaxWidth(), elevation = null,
                colors = ButtonDefaults.buttonColors
                    (backgroundColor = Color.Transparent)
            ) {
                Row(horizontalArrangement = Arrangement.Start) {
                    Image(
                        painter = painterResource(R.drawable.ikon2),
                        contentDescription = "ikon2",
                        modifier = Modifier
                            .size(width = 50.dp, height = 30.dp)
                            .wrapContentWidth(Alignment.Start)
                    )
                    Text(
                        stringResource(R.string.tidligere),
                        fontSize = 18.sp,
                        fontFamily = FontFamily.Serif
                    )
                }
            }
            Spacer(modifier = Modifier.height(15.dp))
            Button(
                onClick = {
                    navController.navigate(Screen.KindStart.withArgs("Gæst"))
                }, modifier = Modifier.fillMaxWidth(), elevation = null,
                colors = ButtonDefaults.buttonColors
                    (backgroundColor = Color.Transparent)
            ) {
                Image(
                    painter = painterResource(R.drawable.ikon3),
                    contentDescription = "ikon3",
                    modifier = Modifier.size(width = 50.dp, height = 30.dp)
                )
                Text(
                    stringResource(R.string.oplysninger),
                    fontSize = 18.sp,
                    fontFamily = FontFamily.Serif
                )
            }
            Spacer(modifier = Modifier.height(14.dp))
            Button(
                onClick = {
                    navController.navigate(Screen.KindStart.withArgs("Gæst"))
                }, modifier = Modifier.fillMaxWidth(), elevation = null,
                colors = ButtonDefaults.buttonColors
                    (backgroundColor = Color.Transparent)
            ) {
                Image(
                    painter = painterResource(R.drawable.ikon4),
                    contentDescription = "ikon4",
                    modifier = Modifier.size(width = 50.dp, height = 30.dp)
                )

                Text(
                    stringResource(R.string.notifikationer),
                    fontSize = 18.sp,
                    fontFamily = FontFamily.Serif
                )
            }

            Button(
                onClick = {
                    navController.navigate(Screen.KindStart.withArgs("Gæst"))
                }, modifier = Modifier.fillMaxWidth(), elevation = null,
                colors = ButtonDefaults.buttonColors
                    (backgroundColor = Color.Transparent)
            ) {
                Image(
                    painter = painterResource(R.drawable.ikon5),
                    contentDescription = "ikon5",
                    modifier = Modifier.size(width = 50.dp, height = 30.dp)
                )
                Text(
                    stringResource(R.string.sikkerhed),
                    fontSize = 18.sp,
                    fontFamily = FontFamily.Serif
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            Button(
                onClick = {
                    navController.navigate(Screen.KindStart.withArgs("Gæst"))
                }, modifier = Modifier.fillMaxWidth(), elevation = null,
                colors = ButtonDefaults.buttonColors
                    (backgroundColor = Color.Transparent)
            ) {
                Image(
                    painter = painterResource(R.drawable.ikon6),
                    contentDescription = "ikon6",
                    modifier = Modifier.size(width = 50.dp, height = 30.dp)
                )
                Text(
                    stringResource(R.string.hjælp),
                    fontSize = 18.sp,
                    fontFamily = FontFamily.Serif
                )
            }

            Button(
                onClick = {
                    navController.navigate(Screen.KindStart.withArgs("Gæst"))
                }, modifier = Modifier.fillMaxWidth(), elevation = null,
                colors = ButtonDefaults.buttonColors
                    (backgroundColor = Color.Transparent)
            ) {
                Image(
                    painter = painterResource(R.drawable.ikon7),
                    contentDescription = "ikon7",
                    modifier = Modifier.size(width = 50.dp, height = 30.dp)
                )
                Text(
                    stringResource(R.string.problem),
                    fontSize = 18.sp,
                    fontFamily = FontFamily.Serif
                )
            }

            Spacer(modifier = Modifier.height(35.dp))

            Button(
                onClick = {
                    navController.navigate(Screen.KindStart.withArgs("Gæst"))
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

/*
@Preview
    (showBackground = true)
@Composable
fun MinKontoPreview() {
    MinKonto()
}
*/

