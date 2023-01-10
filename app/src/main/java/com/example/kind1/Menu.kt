package com.example.kind1

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun Menu(modifier: Modifier = Modifier, navController: NavController) {
    Image(
        contentScale = ContentScale.FillBounds,
        painter = painterResource(id = R.drawable.bekindbackground2),
        contentDescription = null,
        modifier = Modifier.fillMaxSize()
    )
    Column {
        Spacer(modifier = Modifier.height(5.dp).width(5.dp))
    Row {
        Image(painter = painterResource(id = R.drawable.bekindtitel), contentDescription = null,
            modifier = Modifier
                .clickable {
                    navController.navigate(Screen.KindFront.route)
                }
                .size(width = 40.dp, height = 20.dp)
        )

        Spacer(modifier = Modifier.width(290.dp))
    Image(painter = painterResource(id = R.drawable.menuicon), contentDescription = null,
        modifier = Modifier.size(width = 40.dp, height = 20.dp)
            .clickable {
                navController.navigate(Screen.MinKonto.route)
            }
            .size(width = 40.dp, height = 20.dp)
    )
}
        Text(
            text = "Menu",
            fontSize = 40.sp,
            fontFamily = FontFamily.Serif,
            color = Color(0xFF315C36),
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.Start)
        )
        Text(
            text = "Udforsk:",
            fontSize = 20.sp,
            fontFamily = FontFamily.Serif,
            color = Color(0xFF315C36)
        )

        Button(
            onClick = {
                navController.navigate(Screen.Portfølje.route)
            }, modifier = Modifier.fillMaxWidth().wrapContentWidth(Alignment.Start), elevation = null,
            colors = ButtonDefaults.buttonColors
                (backgroundColor = Color.Transparent)
        ) {
                Text(
                    stringResource(R.string.dinportefølje),
                    fontSize = 18.sp,
                    fontFamily = FontFamily.Serif,
                    color = Color(0xFF315C36),
                    style = androidx.compose.ui.text.TextStyle(textDecoration = TextDecoration.Underline),
                    modifier = Modifier.wrapContentWidth(Alignment.Start)

                )
            }
        Button(
            onClick = {
                navController.navigate(Screen.BygPortfølje.route)
            }, modifier = Modifier.fillMaxWidth().wrapContentWidth(Alignment.Start), elevation = null,
            colors = ButtonDefaults.buttonColors
                (backgroundColor = Color.Transparent)
        ) {
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                stringResource(R.string.bygportefølje),
                fontSize = 16.sp,
                fontFamily = FontFamily.Serif,
                color = Color(0xFF315C36),
                modifier = Modifier.wrapContentWidth(Alignment.Start)

            )
        }
        Button(
            onClick = {
                //navController.navigate(Screen.Portfølje.route)
            }, modifier = Modifier.fillMaxWidth().wrapContentWidth(Alignment.Start), elevation = null,
            colors = ButtonDefaults.buttonColors
                (backgroundColor = Color.Transparent)
        ) {
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                stringResource(R.string.socialtudsat),
                fontSize = 16.sp,
                fontFamily = FontFamily.Serif,
                color = Color(0xFF315C36),
                modifier = Modifier.wrapContentWidth(Alignment.Start)

            )
        }
        Button(
            onClick = {
            //    navController.navigate(Screen.Portfølje.route)
            }, modifier = Modifier.fillMaxWidth().wrapContentWidth(Alignment.Start), elevation = null,
            colors = ButtonDefaults.buttonColors
                (backgroundColor = Color.Transparent)
        ) {
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                stringResource(R.string.miljø),
                fontSize = 16.sp,
                fontFamily = FontFamily.Serif,
                color = Color(0xFF315C36),
                modifier = Modifier.wrapContentWidth(Alignment.Start)

            )
        }
        Button(
            onClick = {
            //    navController.navigate(Screen.Portfølje.route)
            }, modifier = Modifier.fillMaxWidth().wrapContentWidth(Alignment.Start), elevation = null,
            colors = ButtonDefaults.buttonColors
                (backgroundColor = Color.Transparent)
        ) {
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                stringResource(R.string.sundhed),
                fontSize = 16.sp,
                fontFamily = FontFamily.Serif,
                color = Color(0xFF315C36),
                modifier = Modifier.wrapContentWidth(Alignment.Start)

            )
        }
        Button(
            onClick = {
                //    navController.navigate(Screen.Portfølje.route)
            }, modifier = Modifier.fillMaxWidth().wrapContentWidth(Alignment.Start), elevation = null,
            colors = ButtonDefaults.buttonColors
                (backgroundColor = Color.Transparent)
        ) {
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                stringResource(R.string.dyrevelfærd),
                fontSize = 16.sp,
                fontFamily = FontFamily.Serif,
                color = Color(0xFF315C36),
                modifier = Modifier.wrapContentWidth(Alignment.Start)

            )
        }
        Button(
            onClick = {
                navController.navigate(Screen.MinKonto.route)
            }, modifier = Modifier.fillMaxWidth().wrapContentWidth(Alignment.Start), elevation = null,
            colors = ButtonDefaults.buttonColors
                (backgroundColor = Color.Transparent)
        ) {
            Text(
                stringResource(R.string.minkonto),
                fontSize = 18.sp,
                fontFamily = FontFamily.Serif,
                color = Color(0xFF315C36),
                style = androidx.compose.ui.text.TextStyle(textDecoration = TextDecoration.Underline),
                modifier = Modifier.wrapContentWidth(Alignment.Start)

            )
        }
        Button(
            onClick = {
            //    navController.navigate(Screen.Portfølje.route)
            }, modifier = Modifier.fillMaxWidth().wrapContentWidth(Alignment.Start), elevation = null,
            colors = ButtonDefaults.buttonColors
                (backgroundColor = Color.Transparent)
        ) {
            Text(
                stringResource(R.string.omos),
                fontSize = 18.sp,
                fontFamily = FontFamily.Serif,
                color = Color(0xFF315C36),
                style = androidx.compose.ui.text.TextStyle(textDecoration = TextDecoration.Underline),
                modifier = Modifier.wrapContentWidth(Alignment.Start)

            )
        }
        }


    }
