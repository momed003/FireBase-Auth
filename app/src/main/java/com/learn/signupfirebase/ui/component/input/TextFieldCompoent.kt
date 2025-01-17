package com.learn.signupfirebase.ui.component.input

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.learn.signupfirebase.ui.theme.MainColor


@Composable
fun TextFieldLabel(
    message: String = "Digite seu e-mail",
    value: String,
    onValueChange: (String) -> Unit
) {

    TextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(message) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(22.dp)
            .border(2.dp, MainColor)
            .background(Color.Transparent),
        singleLine = true,
        colors = TextFieldDefaults.colors(
            focusedTextColor = Color.DarkGray, // Cor do texto quando focado
            unfocusedTextColor = Color.Gray  // Cor do texto quando não focado
        )
    )
}

@Preview
@Composable
fun PasswordField(message: String = "Digite a senha", value: String, onValueChange: (String) -> Unit) {
    var password by rememberSaveable { mutableStateOf("") }

    TextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(message) },
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        modifier = Modifier
            .fillMaxWidth()
            .padding(22.dp)
            .border(2.dp, MainColor)
            .background(Color.Transparent),
        singleLine = true
    )


}