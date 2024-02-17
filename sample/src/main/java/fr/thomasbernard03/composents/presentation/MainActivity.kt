package fr.thomasbernard03.composents.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import fr.thomasbernard03.composents.navigationbars.NavigationBar
import fr.thomasbernard03.composents.animations.animatedComposable
import fr.thomasbernard03.composents.presentation.buttons.ButtonsScreen
import fr.thomasbernard03.composents.presentation.dropdowns.DropDownsScreen
import fr.thomasbernard03.composents.presentation.home.HomeScreen
import fr.thomasbernard03.composents.presentation.navigationbars.NavigationBarsScreen
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
                            showBackButton = navController.currentBackStackEntryAsState().value?.destination?.route != "home",
                            onBack = navController::navigateUp
                        )
                    }
                ) {
                    Surface(
                        modifier = Modifier.padding(it),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        NavHost(navController = navController, startDestination = "home"){
                            animatedComposable("home"){
                                subtitle = ""
                                HomeScreen(navController = navController)
                            }
                            animatedComposable("buttons"){
                                subtitle = "Buttons"
                                ButtonsScreen()
                            }

                            animatedComposable("dropdowns"){
                                subtitle = "Dropdowns"
                                DropDownsScreen()
                            }

                            animatedComposable("navigationbars"){
                                subtitle = "Navigation bars"
                                NavigationBarsScreen()
                            }
                        }
                    }
                }
            }
        }
    }
}