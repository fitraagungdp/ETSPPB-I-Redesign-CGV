package com.example.movieapp

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import android.os.Bundle
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}

@Composable
fun MyApp() {
    val navController = rememberNavController()
    Surface(modifier = Modifier.fillMaxSize()) {
        NavHost(navController = navController, startDestination = "login") {
            composable("login") { LoginScreen(navController) }
            composable("home") { HomeScreen(navController) }
            composable("seat") { SeatSelectorScreen(navController) }

        }
    }
}
