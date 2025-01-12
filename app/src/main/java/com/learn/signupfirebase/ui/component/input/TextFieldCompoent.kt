package com.learn.signupfirebase.ui.component.input

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.learn.signupfirebase.R

@Preview
@Composable
fun TextFieldIcon(text: String){
    TextField(
        value = text,
        onValueChange = {},
        label = { Text("Digite seu e-mail") },
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.email),
                contentDescription = "Ícone de E-mail",
            )
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp)
    )
}