package com.example.kind1

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun Miljø (modifier: Modifier = Modifier, navController: NavController)
{
    Column {
        val shape = RoundedCornerShape(12.dp)
        Spacer(modifier = Modifier.height(10.dp))
        Image(painter = painterResource(id = R.drawable.backbutton), contentDescription = null,
            modifier = Modifier
                .clickable {
                    navController.navigate(Screen.KindFront.route)
                }
                .size(width = 50.dp, height = 30.dp)
        )
    }
}