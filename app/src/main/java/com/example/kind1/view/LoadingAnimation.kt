package com.example.kind1

import android.annotation.SuppressLint
import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.delay

@Composable
fun LoadingAnimationScreen(username: String?, navController: NavController){
    Card(elevation = 2.dp) {
        Image(
            contentScale = ContentScale.FillBounds,
            painter = painterResource(id = R.drawable.bekindbackground2),
            contentDescription = null,
            modifier = Modifier.fillMaxSize()
        )
        Column(
            Modifier
                .fillMaxSize()
                .wrapContentSize(Alignment.Center)) {
            var startAnimation by remember {
                mutableStateOf(false)
            }
            val alphaAnim = animateFloatAsState(
                targetValue = if(startAnimation) 1f else 0f,
                animationSpec = tween(
                    durationMillis = 6000
                )
            )
            LaunchedEffect(key1 = true){
                startAnimation = true
                delay(4000)
                navController.navigate(Screen.KindBekræftet.withArgs(username.toString()))
            }
                LoadingAnimation(modifier = Modifier, alpha = alphaAnim.value)


        }



        }
    }


@SuppressLint("SuspiciousIndentation")
@Composable
fun LoadingAnimation(
    alpha: Float,
    modifier: Modifier,
    circleSize: Dp = 40.dp,
    circleColor: Color = MaterialTheme.colors.secondaryVariant,
    spaceBetween: Dp = 10.dp,
    travelDistance: Dp = 20.dp)
{
    val circles = listOf(
        remember { Animatable(initialValue = 0f) },
        remember { Animatable(initialValue = 0f) },
        remember { Animatable(initialValue = 0f) }
    )

        circles.forEachIndexed { index, animatable ->
            LaunchedEffect(key1 = animatable) {
                delay(index * 100L)
                animatable.animateTo(
                    targetValue = 1f,
                    animationSpec = infiniteRepeatable(
                        animation = keyframes {
                            durationMillis = 1200
                            0.0f at 0 with LinearOutSlowInEasing
                            1.0f at 300 with LinearOutSlowInEasing
                            0.0f at 600 with LinearOutSlowInEasing
                            0.0f at 1200 with LinearOutSlowInEasing
                        },
                        repeatMode = RepeatMode.Restart
                    )
                )
            }
    }
    val circleValues = circles.map { it.value }
    val distance = with(LocalDensity.current) {travelDistance.toPx()
    }
    //val lastCircle = circleValues.size - 1
    Row(modifier = modifier,
            horizontalArrangement = Arrangement.spacedBy(spaceBetween)) {
        circleValues.forEachIndexed { index, value ->
            Box(modifier= modifier
                .size(circleSize)
                .graphicsLayer {
                    translationY = -value * distance
                }
                .background(
                    color = circleColor,
                    shape = CircleShape
                )
            )
            //if (index != lastCircle){
                //Spacer(modifier = Modifier.width(spaceBetween))
            //}
        }
    }

}
/*
@Preview
@Composable
fun LoadingAnimationPreview(){
    LoadingAnimationScreen()
}
 */
