package com.example.keretavoltase.core.components

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.keretavoltase.core.theme.MediumGreen

@Composable
fun GreenButton(modifier: Modifier = Modifier, onClick:() -> Unit, text: String = "Button") {
    Button(
        onClick = { onClick() },
        colors = ButtonDefaults.buttonColors(containerColor = MediumGreen),
        modifier = modifier
    ) {
        Text(text = text, color = Color.Black)
    }
}