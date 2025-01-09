package com.learn.signupfirebase.ui.screen.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.learn.signupfirebase.R
import com.learn.signupfirebase.ui.theme.PinkColor
import androidx.compose.material3.Text
import com.learn.signupfirebase.ui.component.TextFieldIcon

@Preview
@Composable
fun LoginScreen() {
    var text= remember{ mutableStateOf("") }

    Scaffold(

    ) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {
            Column(
                Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .clip(RoundedCornerShape(bottomStart = 40.dp, bottomEnd = 40.dp))
                    .background(PinkColor),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(R.drawable.logo),
                    contentDescription = "",
                    modifier = Modifier.size(200.dp)
                )
            }

            Spacer(modifier=Modifier.height(20.dp))

            TextFieldIcon(text.toString())

        }
    }
}