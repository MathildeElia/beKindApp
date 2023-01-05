package com.example.kind1

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.kind1.ui.theme.DarkGreen

@Composable
fun MinKonto(modifier: Modifier = Modifier, navController: NavController)
{
    //Surface(color = MaterialTheme.colors.background) {}
    Image(
        painter = painterResource(id = R.drawable.bekindforside), contentDescription = null,
        modifier = Modifier
            .padding(vertical = 10.dp)

    )
    Column (
        Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.TopCenter)

    )
        {
        Row(Modifier.align(Alignment.Start)) {
            Image(painter = painterResource(id = R.drawable.backbutton), contentDescription = null,
                modifier = Modifier
                    .clickable {
                        navController.navigate(Screen.KindFront.route)
                    }
                    .size(width = 50.dp, height = 30.dp)
            )
                Image(painter = painterResource(id = R.drawable.menuicon), contentDescription = null,
                    modifier = Modifier
                        .clickable {
                            navController.navigate(Screen.KindFront.route)
                        }
                        .size(width = 40.dp, height = 20.dp)
                        .wrapContentSize(Alignment.CenterStart)

                )
            }
        Text(
            text = text2,
            fontSize = 24.sp,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.Start))

        Text(
            text = text3,
            fontSize = 18.sp,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.Start))
        /*
        Image(
            painter = painterResource(R.drawable.bekindforside),
            contentDescription = "forside billede"
            )
         */

        Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = {
                    navController.navigate(Screen.KindLogin.route)

                }, modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors
                    (backgroundColor = Color(R.color.palegreen))
            ) {
                Image(
                    painter = painterResource(R.drawable.ikon1),
                    contentDescription = "ikon1",
                    modifier = Modifier.size(width = 50.dp, height = 30.dp)
                )

                Text(stringResource(R.string.kommende),textAlign = TextAlign.Left)

                //Color(R.color.darkgreen)
            }

            Button(

                onClick = {
                    navController.navigate(Screen.KindSignUp.route)
                }, modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors
                    (backgroundColor = Color(R.color.darkgreen))
            ) {
                Row(){
                    Image(
                        painter = painterResource(R.drawable.ikon2),
                        contentDescription = "ikon2",
                        modifier = Modifier.size(width = 50.dp, height = 30.dp))
                    Text(stringResource(R.string.tidligere))
                }
            }

            Button(
                onClick = {
                    navController.navigate(Screen.KindStart.withArgs("Gæst"))
                }, modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors
                    (backgroundColor = Color(R.color.darkgreen))
            ) {
                Image(
                    painter = painterResource(R.drawable.ikon3),
                    contentDescription = "ikon3",
                    modifier = Modifier.size(width = 50.dp, height = 30.dp))
                Text(stringResource(R.string.oplysninger))
            }

            Button(
                onClick = {
                    navController.navigate(Screen.KindStart.withArgs("Gæst"))
                }, modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors
                    (backgroundColor = Color(R.color.darkgreen))
            ) {  Image(
                painter = painterResource(R.drawable.ikon4),
                contentDescription = "ikon4",
                modifier = Modifier.size(width = 50.dp, height = 30.dp))

                Text(stringResource(R.string.notifikationer))
            }

        Button(onClick = {
            navController.navigate(Screen.KindStart.withArgs("Gæst"))
        },modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors
                (backgroundColor =  Color(R.color.darkgreen)) ){
            Image(
                painter = painterResource(R.drawable.ikon5),
                contentDescription = "ikon5",
                modifier = Modifier.size(width = 50.dp, height = 30.dp)
            )
            Text(stringResource(R.string.sikkerhed))
        }

            Button(
                onClick = {
                    navController.navigate(Screen.KindStart.withArgs("Gæst"))
                }, modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors
                    (backgroundColor = Color(R.color.darkgreen))
            ) {
                    Image(
                        painter = painterResource(R.drawable.ikon6),
                        contentDescription = "ikon6",
                        modifier = Modifier.size(width = 50.dp, height = 30.dp)
                    )
                Text(stringResource(R.string.hjælp))
            }

            Button(
                onClick = {
                    navController.navigate(Screen.KindStart.withArgs("Gæst"))
                }, modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors
                    (backgroundColor = Color(R.color.darkgreen))
            ) {
                    Image(
                        painter = painterResource(R.drawable.ikon7),
                        contentDescription = "ikon7",
                        modifier = Modifier.size(width = 50.dp, height = 30.dp)
                    )
                Text(stringResource(R.string.problem))
            }

        Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    navController.navigate(Screen.KindStart.withArgs("Gæst"))
                }, modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors
                    (backgroundColor = Color(R.color.darkgreen))
            ) {
                Text(stringResource(R.string.logaf), textAlign = TextAlign.Left)
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

