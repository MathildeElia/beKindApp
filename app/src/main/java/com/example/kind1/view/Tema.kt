package com.example.kind1

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.kind1.data.Organisation

@Composable
fun Tema(theme: String, navController: NavController, viewmodel: VMtema) {

    DisposableEffect(key1 = viewmodel) {
        theme?.let { viewmodel.getThemeOrg(it) }
        onDispose { }
    }
    var organisations = viewmodel.temaState.collectAsState().value.orgList

    //val organisations = viewmodel.organisationState.collectAsState().value.organisation

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
            Image(painter = painterResource(id = R.drawable.backbutton), contentDescription = null,
                modifier = Modifier
                    .clickable {
                        navController.navigate(Screen.BygPortfølje.route)
                    }
                    .size(width = 50.dp, height = 30.dp)
            )

            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "\t\t" + theme,
                modifier = Modifier,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                fontSize = 30.sp,
                color = Color(0xFF315C36)
            )

            Spacer(modifier = Modifier.height(15.dp))

            Text(
                text = "\t\t2 Linjers Random Text ",
                modifier = Modifier,
                fontSize = 18.sp,
                //color = Color(0xFF034A0B),
                color = Color(0xFF315C36)
            )

            Text(
                text = "\t\t2 Linjers Random Text.",
                modifier = Modifier,
                fontSize = 18.sp,
                color = Color(0xFF315C36)
            )

            Spacer(modifier = Modifier.height(40.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentSize(Alignment.Center)
            ) {
                /*Box(
                    modifier = Modifier
                        .size(275.dp, 165.dp)
                        .clip(shape)
                        .background(Color.White)
                )
                */
                //OrgGrids(organisationList = organisations)
            }
        }
    }
}

@Composable
@OptIn(ExperimentalMaterialApi::class)
fun OrgList(organisationList: List<Organisation>) {
    val orgCards = mutableListOf<Any>()
    var bool = false
    for (organisation in organisationList) {
        val tempOrg: Any = {
            bool=true
        }
        if (bool){
            bool = false
            OrgCard(organisation = organisation)
        }
        orgCards.add(tempOrg)
    }


    LazyVerticalGrid(GridCells.Fixed(1)) {
        orgCards.forEachIndexed { index, function ->
            item {
                OrgCard(organisation = organisationList.get(index))
            }
        }
    }
}

@Composable
fun OrgCard(organisation: Organisation) {
    Card() {
        Text(text = organisation.name)
        Text(text = organisation.subheading)
        Text(text = organisation.description)
    }
}


/*
//TODO Husk at skriv hvor koden er fra!

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun OrgGrids(organisationList: List<Organisation>) {
    // on below line creating a column
    // to display our retrieved list.
    Column(
        // adding modifier for our column
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .background(androidx.compose.ui.graphics.Color.White),
        // on below line adding vertical and
        // horizontal alignment for column.
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // on below line we are
        // calling lazy column
        // for displaying listview.
        LazyColumn {
            // on below line we are setting data
            // for each item of our listview.
            itemsIndexed(organisationList) { index, item ->
                // on below line we are creating
                // a card for our list view item.
                Card(
                    onClick = {
                    },
                    // on below line we are adding
                    // padding from our all sides.
                    modifier = Modifier.padding(8.dp),

                    // on below line we are adding
                    // elevation for the card.
                    elevation = 6.dp
                ) {
                    // on below line we are creating
                    // a row for our list view item.
                    Column(
                        // for our row we are adding modifier
                        // to set padding from all sides.
                        modifier = Modifier
                            .padding(8.dp)
                            .fillMaxWidth()
                    ) {
                        // on below line inside row we are adding spacer
                        Spacer(modifier = Modifier.width(5.dp))
                        // on below line we are displaying course name.
                        organisationList[index]?.name?.let {
                            Text(
                                // inside the text on below line we are
                                // setting text as the language name
                                // from our modal class.
                                text = it,

                                // on below line we are adding padding
                                // for our text from all sides.
                                modifier = Modifier.padding(4.dp),

                                // on below line we are adding
                                // color for our text
                                color = Color.White,
                                textAlign = TextAlign.Center,
                                style = TextStyle(
                                    fontSize = 20.sp, fontWeight = FontWeight.Bold
                                )
                            )
                        }
                        // adding spacer on below line.
                        Spacer(modifier = Modifier.height(5.dp))

                        // on below line displaying text for course description
                        organisationList[index]?.description?.let {
                            Text(
                                // inside the text on below line we are
                                // setting text as the language name
                                // from our modal class.
                                text = it,

                                // on below line we are adding padding
                                // for our text from all sides.
                                modifier = Modifier.padding(4.dp),

                                // on below line we are adding color for our text
                                color = Color.Black,
                                textAlign = TextAlign.Center,
                                style = TextStyle(fontSize = 15.sp)
                            )
                        }
                    }
                }
            }
        }
    }
}

 */
