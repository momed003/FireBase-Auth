package com.learn.signupfirebase.ui.component.topapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.learn.signupfirebase.ui.theme.AuxiliarColor
import com.learn.signupfirebase.ui.theme.MainColor
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.learn.signupfirebase.R

@Composable
@Preview
fun CustomTopAppBar(iconBack:Boolean=false, onClick:() -> Unit) {
    Column(Modifier.fillMaxWidth().
        clip(RoundedCornerShape(bottomEnd = 45.dp)).
    background(MainColor)) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(bottomEnd = 1000.dp))
                .background(AuxiliarColor)
                .height(80.dp)
        ) {
            if (iconBack){
                IconButton(onClick = onClick) {
                    Icon(
                        painter = painterResource(R.drawable.back),
                        contentDescription = "",
                        tint = Color.White,
                        modifier = Modifier.size(200.dp).padding(top = 20.dp)
                    )
                }
            }
            Text("       ")
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(30.dp)
                .clip(WaveShape(topHeightFactor = 0f, bottomHeightFactor = 0.5f),
                    )
                .background(MainColor)
        ) {
            Text("      ")
        }
    }
}
fun WaveShape(topHeightFactor: Float, bottomHeightFactor: Float) = GenericShape { size, _ ->
    val width = size.width
    val height = size.height

    moveTo(0f, height * topHeightFactor) // Início da onda (parte esquerda)
    cubicTo(
        width * 0.25f, height * (topHeightFactor - 0.3f), // Primeiro ponto de controle
        width * 0.75f, height * (bottomHeightFactor + 0.1f), // Segundo ponto de controle
        width, height * bottomHeightFactor // Final da onda
    )
    lineTo(width, height) // Borda inferior direita
    lineTo(0f, height)    // Borda inferior esquerda
    close()               // Fecha o path
}