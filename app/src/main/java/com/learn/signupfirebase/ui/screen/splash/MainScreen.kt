package com.learn.signupfirebase.ui.screen.splash

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.learn.signupfirebase.ui.component.topapp.CustomTopAppBar

@Preview
@Composable
fun FirstScreen(){

    Scaffold (
        topBar = {
            CustomTopAppBar (){  }
        }
    ){
        paddingValues ->
        Column (modifier = Modifier.padding(paddingValues)){  }
    }
}