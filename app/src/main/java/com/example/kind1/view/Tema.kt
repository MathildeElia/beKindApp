package com.example.kind1

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.example.kind1.data.Organisation

@Composable
fun Tema(username: String?, theme: String, navController: NavController, vm: VMtema) {

    DisposableEffect(key1 = vm) {
        theme?.let { vm.getThemeOrg(it) }
        onDispose { }
    }
    var organisations = vm.temaState.collectAsState().value.orgList

    Image(
        contentScale = ContentScale.FillBounds,
        painter = painterResource(id = R.drawable.bekindbackground),
        contentDescription = null,
        modifier = Modifier.fillMaxSize()
    )

    Row{
        Spacer(modifier = Modifier.height(10.dp))
        Image(painter = painterResource(id = R.drawable.backbutton), contentDescription = null,
            modifier = Modifier
                .clickable {
                    if (username.equals("Gæst")) {
                        navController.navigate(Screen.Gæst.withArgs("Gæst"))
                    } else {
                        navController.navigate(Screen.BygPortfølje.withArgs(username.toString()))
                    }
                }
                .size(width = 50.dp, height = 30.dp)
        )

        Spacer(modifier = Modifier.width(290.dp))

        if (username.equals("Gæst")) {

        } else {
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

    }
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.height(60.dp))
        Text(
            text = theme,
            modifier = Modifier,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            fontSize = 35.sp,
            color = Color(0xFF315C36)
        )

        Spacer(modifier = Modifier.height(15.dp))

        Text(
            text = vm.getThemeText(theme),
            textAlign = TextAlign.Center,
            fontSize = 19.sp,
            color = Color(0xFF315C36)
        )
        OrgList(username, organisations, navController)

    }
}

@Composable
fun OrgList(username: String?, organisationList: List<Organisation>, navController: NavController) {
    val shape = RoundedCornerShape(12.dp)

    LazyVerticalGrid(
        GridCells.Fixed(1),
        contentPadding = PaddingValues(55.dp),
        modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 40.dp),
        verticalArrangement = Arrangement.spacedBy(40.dp),

        ) {
        items(organisationList) { org ->
            Box(
                modifier = Modifier
                    .size(275.dp, 165.dp)
                    .clip(shape)
                    .background(Color.White)
                    .padding(20.dp)
            ) {
                Column() {
                    Text(
                        org.name,
                        fontSize = 25.sp,
                        modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 10.dp),
                        color = Color(0xFF315C36)
                    )
                    Text(
                        org.subheading, fontSize = 16.sp, color = Color(0xFF315C36)
                    )

                }
                Column(modifier = Modifier.align(Alignment.BottomCenter)) {
                    Text(
                        "Læs mere",
                        modifier = Modifier.clickable {
                            navController.navigate(Screen.Organisation.withArgs(username.toString(),org.name))
                        },
                        fontSize = 16.sp,
                        color = Color.Gray
                    )
                }
            }
        }
    }
}


