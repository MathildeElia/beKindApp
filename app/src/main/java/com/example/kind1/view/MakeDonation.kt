package com.example.kind1

import androidx.compose.animation.AnimatedContentScope.SlideDirection.Companion.Start
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement.Start

import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.Start
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.kind1.data.Donation
import com.example.kind1.data.Organisation
import com.example.kind1.data.User
import com.example.kind1.viewlmodel.VMdonation

@Composable
fun MakeDonationScreen(
    username: String?,
    organisation: String,
    navController: NavController,
    vm: VMdonation
) {
    Card(elevation = 2.dp) {
        var amount by remember {
            mutableStateOf(0)
        }

        Image(
            contentScale = ContentScale.FillBounds,
            painter = painterResource(id = R.drawable.bekindbackground2),
            contentDescription = null,
            modifier = Modifier.fillMaxSize()
        )

        Column(
            Modifier
                .fillMaxSize()
                .wrapContentSize(Alignment.TopCenter)
        ) {
            Row(Modifier.align(Alignment.Start)) {
                Image(painter = painterResource(id = R.drawable.backbutton),
                    contentDescription = null,
                    modifier = Modifier
                        .clickable {
                            navController.navigate(Screen.Organisation.route)
                        }
                        .size(width = 50.dp, height = 30.dp)
                )
            }
            Spacer(modifier = Modifier.height(40.dp))

            Text("Opret donation til [navn]", fontSize = 20.sp, textAlign = TextAlign.Center)
            Spacer(modifier = Modifier.height(40.dp))
            Text("Vælg beløb", fontSize = 15.sp, textAlign = TextAlign.Center)

            amount = amountTextField()

            Spacer(modifier = Modifier.height(40.dp))
            RadioButtons()
            /*
            Row(Modifier.align(Alignment.CenterHorizontally)) {
                CirleButton()
                Spacer(modifier = Modifier.width(60.dp))
                CirleButton()
            }

            Row(Modifier.align(Alignment.CenterHorizontally)) {
                Text(text = "Støt månedligt")
                Spacer(modifier = Modifier.width(60.dp))
                Text("Støt én gang")
            }
             */

            Spacer(modifier = Modifier.height(40.dp))
            NameTextField()
            Spacer(modifier = Modifier.height(10.dp))
            EmailTextField()

            Spacer(modifier = Modifier.height(40.dp))
            if (username != null) {
                SupportButton(amount, username,organisation,vm,navController)
            }
        }
    }
}

@Composable
fun SupportButton(amount: Int, user: String, org: String, vm: VMdonation, nav: NavController) {
    Button(
        onClick = {
            val donation = Donation(amount, org, user)
            vm.addDonationToDatabase(donation)
            nav.navigate(Screen.KindBekræftet.route)
        },
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Yellow),
        modifier = Modifier
            .height(50.dp)
            .width(280.dp)
    ) {
        Text(
            text = "Støt nu", textAlign = TextAlign.Center,
            color = Color.White, fontWeight = FontWeight.Bold, fontSize = 25.sp
        )
    }
}

@Composable
fun amountTextField(): Int {
    var value by remember {
        mutableStateOf("")
    }
    TextField(
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        value = value, onValueChange = { value = it },
        label = { }
    )
    return value.toInt()
}

@Composable
fun NameTextField() {
    var user by remember {
        mutableStateOf("")
    }
    TextField(
        value = user, onValueChange = { user = it },
        label = { Text("Dit fulde navn") }

    )
}

@Composable
fun EmailTextField() {
    var email by remember {
        mutableStateOf("")
    }
    TextField(
        value = email, onValueChange = { email = it },
        label = { Text("Din e-mail") }
    )
}

@Composable
fun CirleButton() {
    val color = remember { mutableStateOf(Color.Transparent) }

    OutlinedButton(
        onClick = { color.value = Color.Yellow },
        modifier = Modifier.size(70.dp),
        shape = CircleShape,
        border = BorderStroke(1.dp, Color.Black),
        contentPadding = PaddingValues(0.dp),  //avoid the little icon
        colors = ButtonDefaults.outlinedButtonColors(backgroundColor = color.value)
    ) {
    }
}

@Composable
fun RadioButtons() {

    val selectedValue = remember { mutableStateOf("") }
    val textToEnableList = listOf(
        "Støt månedligt" to true,
        "Støt én gang" to true
    )

    val isSelectedItem: (String) -> Boolean = { selectedValue.value == it }
    val onChangeState: (String) -> Unit = { selectedValue.value = it }
    Text(text = "Selected value: ${selectedValue.value.ifEmpty { "NONE" }}")

    Row(Modifier.padding(8.dp)) {
        textToEnableList.forEach { textToEnableState ->
            Column(
                Modifier.wrapContentSize()
            ) {
                Box(
                    modifier = Modifier
                        .selectable(
                            selected = isSelectedItem(textToEnableState.first),
                            enabled = textToEnableState.second,
                            onClick = {
                                onChangeState(textToEnableState.first)
                            }
                        )
                        .clip(CircleShape)
                        .border(1.dp, Color.Black, CircleShape)
                        .size(70.dp),
                ) {
                    Box(
                        modifier = Modifier
                            .clip(CircleShape)
                            .background(
                                color = when {
                                    isSelectedItem(textToEnableState.first) -> Color.Yellow
                                    !textToEnableState.second -> Color.LightGray
                                    else -> Color.Transparent
                                }
                            )
                            .size(45.dp)
                            .align(Center)
                    ) {

                    }
                }
                Text(
                    text = textToEnableState.first,
                    color = when {
                        !textToEnableState.second -> Color.LightGray
                        else -> Color.Black
                    },
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}
