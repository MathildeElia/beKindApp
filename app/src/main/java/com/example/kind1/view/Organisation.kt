package com.example.kind1

import android.annotation.SuppressLint
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Cyan
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.kind1.data.Organisation


@SuppressLint("UnrememberedMutableState")
@Composable
fun Organisation(navController: NavController, id: String?, viewmodel: Viewmodel) {

    DisposableEffect(key1 = viewmodel) {
        id?.let { viewmodel.getOgFromDatabase(it) }
        onDispose { }
    }
    val organisation = viewmodel.organisationState.collectAsState().value.organisation

    val shape = RoundedCornerShape(15.dp)

    Card(elevation = 2.dp) {

        Image(
            contentScale = ContentScale.FillBounds,
            painter = painterResource(id = R.drawable.bekindbackground),
            contentDescription = null,
            modifier = Modifier.fillMaxSize()
        )
        Image(painter = painterResource(id = R.drawable.backbutton), contentDescription = null,
            modifier = Modifier
                .clickable {
                    navController.navigate(Screen.Miljo.route)
                }
                .size(width = 50.dp, height = 30.dp)
        )
        Column(
            modifier = Modifier.fillMaxSize(),
            //horizontalAlignment = Alignment.CenterHorizontally
        ) {

            organisation?.name?.let {
                Text(
                    it,
                    textAlign = TextAlign.Start,
                    fontSize = 35.sp,
                    modifier = Modifier.padding(40.dp, 30.dp, 30.dp, 0.dp)
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            organisation.subheading?.let {
                Text(
                    it,
                    textAlign = TextAlign.Start,
                    fontSize = 25.sp,
                    modifier = Modifier.padding(40.dp, 10.dp, 30.dp, 20.dp)
                )
            }
            Button(
                onClick = {
                    //naviger til makeDonation side
                    navController.navigate(Screen.MakeDonation.withArgs("seb", id.toString()))
                }, modifier = Modifier
                    .fillMaxWidth()
                    .padding(40.dp, 0.dp, 40.dp, 20.dp)
                    .clip(shape),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Yellow)
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
            ) {

                organisation.let {
                    Text(
                        it.description,
                        Modifier.padding(15.dp),
                        fontSize = 20.sp
                    )
                }
            }

        }
        //val organisationList = viewmodel.readOrganization()
        //FirebaseUI(context = LocalContext.current, organisationList = organisationList)
    }
}


