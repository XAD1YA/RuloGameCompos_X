package com.xadiyatullox.rulogamecompos_x.ruloScreen


import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.xadiyatullox.rulogamecompos_x.R
import com.xadiyatullox.rulogamecompos_x.utils.NumberUtil
import kotlin.math.roundToInt

@Composable
fun RuloScreen() {

   var rotationValue by remember {
       mutableStateOf(0f)
   }

    var number by  remember {
        mutableStateOf(0)
    }

    val angele : Float by animateFloatAsState(
        targetValue =rotationValue,
        animationSpec = tween(
            durationMillis = 2000,
            easing = LinearOutSlowInEasing
        ),
        finishedListener = {
       val index = (360f- (it % 360)) / (360f / NumberUtil.list.size)
            number= NumberUtil.list[index.roundToInt()]
        }
    )

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .wrapContentHeight()
                .wrapContentWidth(),
            text = number.toString(),
            fontWeight = FontWeight.Bold,
            fontSize = 35.sp,
            color = Color.White
        )
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxSize()){
            Image(
                painter = painterResource(id = R.drawable.img),
                contentDescription ="Rulo"
            )
        }
        Image(
            painter = painterResource(id = R.drawable.img_1),
            contentDescription = "X",
            modifier = Modifier
                .fillMaxSize()
                .rotate(angele)
        )
    }
    Button(
        onClick = {
                  rotationValue = (0..360).random().toFloat()+angele
        },
        colors = ButtonDefaults.buttonColors(backgroundColor = Red),
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Text(
            text = "Start",
            color = White
        )
    }

}





