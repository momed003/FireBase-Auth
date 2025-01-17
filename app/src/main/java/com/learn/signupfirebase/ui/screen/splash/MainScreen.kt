package com.learn.signupfirebase.ui.screen.splash

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.learn.signupfirebase.R
import com.learn.signupfirebase.ui.Screen
import com.learn.signupfirebase.ui.component.topapp.CustomTopAppBar
import com.learn.signupfirebase.ui.theme.AuxiliarColor
import com.learn.signupfirebase.ui.theme.MainColor

//@Preview
@Composable
fun FirstScreen(navController: NavController){

    Scaffold (
        topBar = {
            CustomTopAppBar (){  }
        }
    ){
        paddingValues ->
        Column (modifier = Modifier
            .padding(paddingValues)
            .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally){
           Spacer(Modifier.height(100.dp))

            Text("Bem-vindo",
                color = AuxiliarColor,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                fontSize = 45.sp
            )
          //  Text(" Explore todas a funcionalidades preparadas para si")
            Spacer(Modifier.height(20.dp))
            Image(
                painter = painterResource(R.drawable.people_splash),
                contentDescription = "",
                modifier = Modifier.size(300.dp)
            )
            Spacer(Modifier.height(20.dp))
            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(
                    containerColor = AuxiliarColor,
                    contentColor = Color.White
                ),
                modifier = Modifier.width(200.dp)
            ) {
                Text("Inscrever-se")
            }
            Spacer(Modifier.height(10.dp))
            OutlinedButton(
                onClick = { navController.navigate(Screen.Login.route)},
                modifier = Modifier.width(200.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent,
                    contentColor = AuxiliarColor,
                    disabledContentColor = Color.Gray
                ),
               border = BorderStroke(2.dp, MainColor),

            ) {
                Text("Entrar")
            }

        }
    }
}