package com.learn.signupfirebase.ui.screen.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.learn.signupfirebase.R
import com.learn.signupfirebase.ui.theme.MainColor

@Preview
@Composable
fun Splash() {

    Scaffold(

        topBar = {

        }

    ) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {
            Column(
                Modifier
                    .padding(top = 60.dp)
                    .fillMaxSize()
                    .clip(RoundedCornerShape(topStart = 180.dp, topEnd = 180.dp))
                    .background(MainColor),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                Image(
                    painter = painterResource(R.drawable.lg_sp),
                    contentDescription = "img_spalsh",
                    modifier = Modifier.size(600.dp)
                )

            }
        }
    }
}