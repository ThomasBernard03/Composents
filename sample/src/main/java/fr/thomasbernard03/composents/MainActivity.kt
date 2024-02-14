package fr.thomasbernard03.composents

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import fr.thomasbernard03.composents.ui.theme.ComposentsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposentsTheme {
                Scaffold {
                    Surface(
                        modifier = Modifier.padding(it),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(12.dp),
                            verticalArrangement = Arrangement.spacedBy(12.dp)
                        ) {
                            // Generate a list of 10 items
                            val dropDownItems by remember { mutableStateOf((1..100).toList()) }
                            var selectedItem by remember { mutableStateOf(0) }


                            DropDown(
                                modifier = Modifier.fillMaxWidth(),
                                label = { "Valeur n°$it" },
                                placeholder = "Choose one item",
                                selectedItem = selectedItem,
                                items = dropDownItems
                            ){
                                selectedItem = it
                            }

                            PrimaryButton(
                                modifier = Modifier.fillMaxWidth(),
                                text = "Hello, World!"
                            ){

                            }
                        }
                    }
                }
            }
        }
    }
}