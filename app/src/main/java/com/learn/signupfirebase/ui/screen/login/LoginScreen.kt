package com.learn.signupfirebase.ui.screen.login

import android.util.Log
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
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Popup
import androidx.navigation.NavController
import com.learn.signupfirebase.R
import com.learn.signupfirebase.data.Resource
import com.learn.signupfirebase.ui.Screen
import com.learn.signupfirebase.ui.component.input.PasswordField
import com.learn.signupfirebase.ui.component.input.TextFieldLabel
import com.learn.signupfirebase.ui.component.topapp.CustomTopAppBar
import com.learn.signupfirebase.ui.theme.AuxiliarColor


@Composable
fun Login(viewModel: AuthViewModel, navController: NavController) {

    var email by remember { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }

    val loginFlow = viewModel.loginFlow.collectAsState()

    Scaffold(
        topBar = {
            CustomTopAppBar(iconBack = true,
                onClick = {
                    navController.popBackStack()
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(Modifier.height(50.dp))

            Text(
                "Bem-vindo",
                color = AuxiliarColor,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                fontSize = 45.sp
            )

            Spacer(Modifier.height(20.dp))
            Image(
                painter = painterResource(R.drawable.people_splash),
                contentDescription = "",
                modifier = Modifier.size(200.dp)
            )
            Spacer(Modifier.height(20.dp))

            TextFieldLabel(value = email, onValueChange = { email = it })

            PasswordField(value = password, onValueChange = { password = it })

            Button(
                onClick = {
                    viewModel.login(email, password)
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = AuxiliarColor,
                    contentColor = Color.White
                ),
                modifier = Modifier.width(200.dp)
            ) {
                Text("Entrar")
            }


        }
        loginFlow.value.let {
            when(it){
                is Resource.Error -> TODO()
                Resource.Loading -> {
                    CircularProgressIndicator(/*modifier = Modifier.constrainAs*/)
                    Log.i("Login", "Processing credential, please wait")
                }
                is Resource.Sucess -> {
                    Log.i("Login","User login successful")
                    LaunchedEffect(Unit) {
                        navController.navigate(Screen.Splash.route){
                            popUpTo(Screen.Splash.route){inclusive=true}
                        }
                    }
                }

                null -> TODO()
            }
        }
    }
}