package fr.thomasbernard03.composents.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import fr.thomasbernard03.composents.NavigationBar
import fr.thomasbernard03.composents.presentation.buttons.ButtonsScreen
import fr.thomasbernard03.composents.presentation.home.HomeScreen
import fr.thomasbernard03.composents.ui.theme.ComposentsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposentsTheme {
                val navController = rememberNavController()
                var subtitle by remember { mutableStateOf("") }

                Scaffold(
                    topBar = {
                        // Our custom navigation bar
                        NavigationBar(
                            title = "Composents",
                            subtitle = subtitle,
                            onBack = navController::navigateUp
                        )
                    }
                ) {
                    Surface(
                        modifier = Modifier.padding(it),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        NavHost(navController = navController, startDestination = "home"){
                            composable("home"){
                                subtitle = ""
                                HomeScreen(navController = navController)
                            }
                            composable("buttons"){
                                subtitle = "Buttons"
                                ButtonsScreen()
                            }
                        }
                    }
                }
            }
        }
    }
}