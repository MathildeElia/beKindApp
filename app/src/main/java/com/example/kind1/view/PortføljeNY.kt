package com.example.kind1
//Nu testes der

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.kind1.viewlmodel.VMportefolje

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun PortføljeNy(navController: NavController, username: String?, viewmodel: VMportefolje) {

    DisposableEffect(key1 = viewmodel){
        username?.let { viewmodel.getPortefoljeDon(it) }
        onDispose {  }
    }
    //viewmodel.themeSort()

    val portefølje = viewmodel.portefoljeState.value.portefoljeUi

    var themes = 4
    var charities = 6
    //var percentage = VMportefolje()

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
                        navController.navigate(Screen.KindStart.withArgs(username.toString()))
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
        Column(modifier = Modifier.padding(10.dp)) {

            Text(
                "\t\tPortefølje",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF315C36)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text("Indtil videre støtter du:", fontSize = 18.sp, color = Color(0xFF315C36))
            Spacer(modifier = Modifier.height(2.dp))
            Text("\t\t- $themes temaer", fontSize = 18.sp, color = Color(0xFF315C36))
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                "\t\t- $charities velgørenheds-organisationer",
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
                    text = "Socialt udsatte ${portefølje.socialP} %",
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
                    text = "Miljø ${portefølje.miljøP} %",
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
                    text = "Dyrevelfærd ${portefølje.dyrP} %",
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
                    text = "Sundhed ${portefølje.sundhedP} %",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF315C36)
                )


            }
            Spacer(modifier = Modifier.height(20.dp))
            StøtMereButton(navController,username.toString())


        }
    }
    }
}

@Composable
fun StøtMereButton(navController:NavController,username : String) {
    Button(onClick = {
        navController.navigate(Screen.BygPortfølje.withArgs(username))
    },
        colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF315C36)),
        modifier = Modifier
            .padding(60.dp)
            .wrapContentSize()
            .height(80.dp)
            .width(200.dp)) {
        Text(text = "Støt mere", textAlign = TextAlign.Center,
            color = Color.White,fontWeight = FontWeight.Bold, fontSize = 25.sp
        )
    }
}





