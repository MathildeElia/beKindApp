package com.example.kind1

import android.annotation.SuppressLint
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@SuppressLint("UnrememberedMutableState")
@Composable
fun Organisation(navController: NavController, orgName: String?, viewmodel: Viewmodel, username: String?) {

    DisposableEffect(key1 = viewmodel) {
        orgName?.let { viewmodel.getOgFromDatabase(it) }
        onDispose { }
    }
    val organisation = viewmodel.organisationState.collectAsState().value.organisation

    val shape = RoundedCornerShape(15.dp)


        Image(
            contentScale = ContentScale.FillBounds,
            painter = painterResource(id = R.drawable.bekindbackground),
            contentDescription = null,
            modifier = Modifier.fillMaxSize()
        )
        Image(painter = painterResource(id = R.drawable.backbutton), contentDescription = null,
            modifier = Modifier
                .clickable {
                    navController.navigate(
                        Screen.Tema.withArgs(
                            username.toString(),
                            organisation.theme
                        )
                    )
                }
                .size(width = 50.dp, height = 30.dp)
        )
        Column(
            modifier = Modifier.fillMaxSize(),
        ) {
            Spacer(modifier = Modifier.height(30.dp))
            organisation?.name?.let {
                Text(
                    it,
                    textAlign = TextAlign.Start,
                    fontSize = 35.sp,
                    modifier = Modifier.padding(40.dp, 30.dp, 30.dp, 0.dp),
                    color = Color(0xFF315C36)
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            organisation.subheading?.let {
                Text(
                    it,
                    textAlign = TextAlign.Start,
                    fontSize = 25.sp,
                    modifier = Modifier.padding(40.dp, 10.dp, 30.dp, 20.dp),
                    color = Color(0xFF315C36)
                )
            }
            Button(
                onClick = {
                    //naviger til makeDonation side
                    navController.navigate(Screen.MakeDonation.withArgs(username.toString(),orgName.toString()))
                }, modifier = Modifier
                    .fillMaxWidth()
                    .padding(40.dp, 0.dp, 40.dp, 20.dp)
                    .clip(shape),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(243, 196, 53))
            ) {
                Text("Støt organisationen", color = White, fontSize = 25.sp)
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(40.dp, 0.dp, 40.dp, 0.dp)
                    .align(Alignment.CenterHorizontally)
                    .background(White)
                    .clip(shape)
                    .verticalScroll(rememberScrollState())
            ) {

                organisation.let {
                    Text(
                        it.description,
                        Modifier.padding(15.dp),
                        fontSize = 20.sp,
                        color = Color(0xFF315C36)
                    )
                }
            }

    }
}


