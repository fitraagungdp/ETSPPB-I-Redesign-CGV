package com.example.movieapp

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
//import androidx.compose.material3.TextButton
//import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
//import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController


@Composable
fun LoginScreen(navController: NavHostController){

    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }
    var passwordVisible by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = painterResource(id = R.drawable.cgv), contentDescription = "Login Image",
            modifier = Modifier.size(300.dp))

        Text(text = "WELCOME", fontSize = 28.sp, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(4.dp))

        Row {
            Text(text = "Login to CGV Cinemas")
        }

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(value = email, onValueChange = {email = it}, label = {
            Text(text = "Email")
        })

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text(text = "Password") },
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(
                        imageVector = if (passwordVisible) Icons.Filled.Add else Icons.Filled.Close,
                        contentDescription = if (passwordVisible) "Hide password" else "Show password"
                    )
                }
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                Log.i("Credential", "Email : $email Password : $email")
                navController.navigate("home")
            },
            modifier = Modifier.size(width = 200.dp, height = 60.dp)
        ) {
            Text(text = "LOGIN")
        }


        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Forgot Password ?", modifier = Modifier.clickable {})

        Spacer(modifier = Modifier.height(32.dp))

        Text(text = "Or Sign in With")


        Row (modifier = Modifier
            .fillMaxWidth()
            .padding(40.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ){

            Image(painter = painterResource(id = R.drawable.login2),
                contentDescription = "login 1",
                modifier = Modifier
                    .size(60.dp)
                    .clickable {

                    }
            )

            Image(painter = painterResource(id = R.drawable.login4),
                contentDescription = "login 2",
                modifier = Modifier
                    .size(60.dp)
                    .clickable {

                    }
            )

            Image(painter = painterResource(id = R.drawable.login5),
                contentDescription = "login 3",
                modifier = Modifier
                    .size(60.dp)
                    .clickable {

                    }
            )
        }

    }

}