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
val text2= "Min Konto"
val text3 = "Nick Tahmasebi" //midlertidig løsning - skal selvfølgelig være den bruger der logger på

@Preview

    (showBackground = true)
@Composable
fun KindApp() {
   Navigation()
    }

