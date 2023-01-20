package com.example.kind1

import android.annotation.SuppressLint
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
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
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.kind1.viewlmodel.VMorganisation


@SuppressLint("UnrememberedMutableState")
@Composable
fun Organisation(
    navController: NavController,
    orgName: String?,
    viewmodel: VMorganisation,
    username: String?
) {

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

    Row {
        Spacer(modifier = Modifier.height(10.dp))
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
                if (username.equals("Gæst")) {
                   navController.navigate(Screen.KindSignUp.route)
                } else {
                    navController.navigate(
                        Screen.MakeDonation.withArgs(
                            username.toString(),
                            orgName.toString()
                        )
                    )
                }

            }, modifier = Modifier
                .fillMaxWidth()
                .padding(40.dp, 0.dp, 40.dp, 20.dp)
                .clip(shape),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(243, 196, 53))
        ) {
            if (username.equals("Gæst")) {
                Text("Opret bruger for at støtte", color = White, fontSize = 22.sp)
            } else {
                Text("Støt organisationen", color = White, fontSize = 25.sp)
            }
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
            Column {

                organisation.let {
                    Text(
                        it.description,
                        Modifier.padding(15.dp),
                        fontSize = 20.sp,
                        color = Color(0xFF315C36)
                    )
                }
                Row(Modifier.align(Alignment.CenterHorizontally)) {

                    hyperLinkText(
                        fulltext = "Læs mere på deres hjemmeside her",
                        linkText = listOf("her"),
                        hyperlink = listOf(organisation.link.toString())
                        // listOf("https://learntodroid.com/how-to-create-a-hyperlink-using-android-textview/")
                    )
                }
            }
        }
    }
}

@Composable
fun hyperLinkText(

    fulltext: String,
    linkText: List<String>,
    linkTextColor: Color = Color.Blue,
    linkTextFontWeight: FontWeight = FontWeight.Medium,
    linkTextDecoration: TextDecoration = TextDecoration.Underline,
    hyperlink: List<String>,
    fontSize: TextUnit = 18.sp
) {
    val annotatedString = buildAnnotatedString {
        linkText.forEachIndexed { index, link ->
            append(fulltext)
            val startIndex = fulltext.indexOf(link)
            val endIndex = startIndex + link.length
            addStyle(
                style = SpanStyle(
                    color = linkTextColor,
                    fontSize = fontSize,
                    fontWeight = linkTextFontWeight,
                    textDecoration = linkTextDecoration
                ),
                start = startIndex,
                end = endIndex
            )
            addStringAnnotation(
                tag = "URL",
                annotation = hyperlink[index],
                start = startIndex,
                end = endIndex
            )
        }
        addStyle(
            style = SpanStyle(
                fontSize = fontSize
            ),
            start = 0,
            end = fulltext.length
        )
    }
    val uriHandler = LocalUriHandler.current
    ClickableText(
        text = annotatedString,
        onClick = {
            annotatedString
                .getStringAnnotations("URL", it, it)
                .firstOrNull()?.let { stringAnnotation ->
                    uriHandler.openUri(stringAnnotation.item)
                }
        })
}


