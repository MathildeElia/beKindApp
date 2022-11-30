package com.example.kind1
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun KindFront(modifier: Modifier = Modifier,navController: NavController) {
    Column (
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Image(
            painter = painterResource(R.drawable.bekindtitel),
            contentDescription = "titel"
        )
        Text(
            text = text1,
            fontSize = 24.sp,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.CenterHorizontally)
        )

        Image(
            painter = painterResource(R.drawable.bekindforside),
            contentDescription = "forside billede"
        )
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            navController.navigate(Screen.KindLogin.route)
        },
            colors = ButtonDefaults.buttonColors
                (backgroundColor =  Color(R.color.darkgreen))){
            Text(stringResource(R.string.log))
            //Color(R.color.darkgreen)
        }
        Button(onClick = {
                         navController.navigate(Screen.KindSignUp.route)
                         },
            colors = ButtonDefaults.buttonColors
                (backgroundColor =  Color(R.color.darkgreen))){
            Text(stringResource(R.string.sign))
        }
        Button(onClick = {
                         navController.navigate(Screen.KindStart.withArgs("Guest"))
                         },
            colors = ButtonDefaults.buttonColors
                (backgroundColor =  Color(R.color.darkgreen)) ){
            Text(stringResource(R.string.senere))
        }
    }
}