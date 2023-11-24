package com.example.keretavoltase

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.keretavoltase.core.components.TextInputField
import com.example.keretavoltase.core.theme.KeretaVoltaseTheme
import com.example.keretavoltase.core.theme.MediumGreen
import com.example.keretavoltase.core.theme.White700
import com.example.keretavoltase.core.utils.pxToDp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KeretaVoltaseTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    KeretaVoltaseTheme {
                        LoginScreen(modifier = Modifier.fillMaxSize()) {

                        }
                    }
                }
            }
        }
    }
}

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    onSuccessfulLogin: () -> Unit
) {

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(32.dp),
        verticalArrangement = Arrangement.SpaceAround
    ) {
//        val viewModel: AuthViewModel = viewModel()
//        val res = viewModel.loginResponse.collectAsState(initial = "init")
        Row(
            modifier = modifier
        ) {
            Text(
                text = "random text",
                style = MaterialTheme.typography.headlineMedium,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                modifier = modifier
                    .fillMaxWidth()
            )
        }

        Column(
            modifier = modifier
                .fillMaxHeight(0.55f)
                .clip(shape = RoundedCornerShape(5))
                .background(color = White700, shape = RoundedCornerShape(5)),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {

            TextInputField(
                value = "",
                onValueChange = {},
                label = {
                    Text(text = "Email", color = MaterialTheme.colorScheme.primary)
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Email,
                        contentDescription = "Email Icon",
                        tint = MaterialTheme.colorScheme.primary
                    )
                },
                modifier = modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            )

            TextInputField(
                value = "",
                onValueChange = {},
                label = {
                    Text(text = "Password", color = MaterialTheme.colorScheme.primary)
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Lock,
                        contentDescription = "Password Icon",
                        tint = MaterialTheme.colorScheme.background
                    )
                },
                trailingIcon = {
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.Default.Visibility,
                            contentDescription = "Change Password Visibility",
                            tint = MaterialTheme.colorScheme.background
                        )
                    }
                },
                modifier = modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            )

            Spacer(modifier.size(5.pxToDp()))

            Button(
                onClick = onSuccessfulLogin,
                colors = ButtonDefaults.buttonColors(MediumGreen),
                modifier = modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(15))
                    .height(160.pxToDp())
                    .padding(horizontal = 16.dp)
            ) {
                Text("Login")
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    KeretaVoltaseTheme {
        LoginScreen(modifier = Modifier.fillMaxSize()) {

        }
    }
}