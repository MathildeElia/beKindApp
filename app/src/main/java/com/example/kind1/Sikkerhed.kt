package com.example.kind1

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun Sikkerhed(modifier: Modifier = Modifier, navController: NavController) {
    Image(
        contentScale = ContentScale.FillBounds,
        painter = painterResource(id = R.drawable.bekindbackground3),
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
                        navController.navigate(Screen.Menu.route)
                    }
                    .size(width = 40.dp, height = 20.dp)
                    .wrapContentSize(Alignment.TopEnd)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Sikkerhed",
            fontSize = 40.sp,
            fontFamily = FontFamily.Serif,
            color = Color.White,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.CenterHorizontally)
        )
    }
}