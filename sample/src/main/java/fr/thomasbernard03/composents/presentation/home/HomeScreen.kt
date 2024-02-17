package fr.thomasbernard03.composents.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import fr.thomasbernard03.composents.buttons.PrimaryButton

@Composable
fun HomeScreen(navController: NavController){

    Column(
        modifier = Modifier.fillMaxWidth().padding(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        PrimaryButton(
            text = "Buttons",
            modifier = Modifier.fillMaxWidth(),
            onClick = { navController.navigate("buttons") })

    }
}