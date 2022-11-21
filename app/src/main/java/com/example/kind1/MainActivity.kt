package com.example.kind1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.input.key.Key.Companion.Button1
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kind1.ui.theme.Kind1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Kind1Theme {
                KindApp()
            }
        }
    }
}
val text1 = "Begynd at byg dit personlige portefølje af velgørenhed i dag!"
@Preview

    (showBackground = true)
@Composable
fun KindApp() {
    KindLogIn(modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center))
}
@Composable
fun KindLogIn(modifier: Modifier = Modifier) {
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
                .wrapContentWidth(Alignment.Start)
        )

        Image(
            painter = painterResource(R.drawable.bekindforside),
            contentDescription = "forside billede"
        )
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {/*TODO*/},
            colors = ButtonDefaults.buttonColors
                (backgroundColor =  Color(R.color.darkgreen))){
            Text(stringResource(R.string.log))
            //Color(R.color.darkgreen)
        }
        Button(onClick = {/*TODO*/},
            colors = ButtonDefaults.buttonColors
                (backgroundColor =  Color(R.color.darkgreen))){
            Text(stringResource(R.string.sign))
        }
        Button(onClick = {/*TODO*/},
            colors = ButtonDefaults.buttonColors
                (backgroundColor =  Color(R.color.darkgreen)) ){
            Text(stringResource(R.string.senere))
        }
    }
}