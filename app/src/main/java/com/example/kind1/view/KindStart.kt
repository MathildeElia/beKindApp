package com.example.kind1

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.TopStart
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale

@Composable
fun KindStart(username: String?, navController: NavController) {
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
                        navController.navigate(Screen.KindFront.route)
                    }
                    .size(width = 50.dp, height = 30.dp)
            )

            Spacer(modifier = Modifier.width(290.dp))

            Image(painter = painterResource(id = R.drawable.menuicon), contentDescription = null,
                modifier = Modifier
                    .padding(20.dp, 5.dp, 0.dp, 10.dp)
                    .clickable {
                        navController.navigate(Screen.Menu.withArgs(username.toString()))
                    }
                    .size(width = 40.dp, height = 20.dp)
                    .wrapContentSize(Alignment.TopEnd)
            )
            }


            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "\t\tHej $username!",
                modifier = Modifier,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Left,
                fontSize = 25.sp,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(15.dp))

            Text(
                text = "\t\tDit abonnenement er på plads og ",
                modifier = Modifier,
                fontSize = 25.sp,
                //color = Color(0xFF034A0B),
                color = Color(0xFF315C36)
            )
            Text(
                text = "\t\tdu er on track til at donere 100 kr.",
                modifier = Modifier,
                fontSize = 25.sp,
                color = Color(0xFF315C36)

            )

            Spacer(modifier = Modifier.height(15.dp))

            Text(
                text = "\t\tDu er blandt top 1% af donerer denne",
                modifier = Modifier,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = Color.White
            )


            Text(
                text = "\t\tmåned. Godt gået!",
                modifier = Modifier,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(20.dp))

            //The first White - TextBox
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentSize(Alignment.Center)
            ) {
                Box(
                    modifier = Modifier
                        .size(275.dp, 200.dp)
                        .clip(shape)
                        .background(Color.White)
                )
                {
                    Image(
                        painter = painterResource(id = R.drawable.bekinglogos),
                        contentDescription = null,
                        modifier = Modifier
                            .size(width = 130.dp, height = 70.dp)
                            .padding(20.dp, 0.dp, 0.dp, 10.dp)
                    )

                    Spacer(modifier = Modifier.height(50.dp))

                    Text(
                        text = "\t\tDin Portfølje →",
                        modifier = Modifier
                            .padding(10.dp, 55.dp, 0.dp, 0.dp)
                            .clickable { navController.navigate(Screen.Portfølje.withArgs(username.toString())) },
                        fontSize = 17.sp,
                        color = Color(0xFF315C36)
                    )

                }
            }



            Spacer(modifier = Modifier.height(20.dp))

            //The second White - TextBox
            Column(

                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentSize(Alignment.Center)
            )
            {
                Box(
                    modifier = Modifier
                        .size(275.dp, 350.dp)
                        .clip(shape)
                        .background(Color.White)
                )
                {
                    Spacer(modifier = Modifier.requiredHeight(32.dp))
                    Text(
                        text = "Velgørenheds Nyheder",
                        modifier = Modifier
                            .align(Alignment.TopCenter)
                            .padding(0.dp, 10.dp, 0.dp, 0.dp),
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        color = Color(0xFF315C36)
                    )
                }
            }

        }
}
    }


