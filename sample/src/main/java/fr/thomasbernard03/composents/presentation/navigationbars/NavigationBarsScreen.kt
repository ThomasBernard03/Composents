package fr.thomasbernard03.composents.presentation.navigationbars

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import fr.thomasbernard03.composents.NavigationBar
import fr.thomasbernard03.composents.R
import fr.thomasbernard03.composents.buttons.SquaredButton

@Composable
fun NavigationBarsScreen(){

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        NavigationBar(
            title = "Navigation bar")

        NavigationBar(
            title = "Navigation bar",
            subtitle = "Subtitle")

        NavigationBar(
            title = "Navigation bar",
            subtitle = "With back button",
            showBackButton = true)

        NavigationBar(
            title = "Navigation bar",
            subtitle = "With action button"){
            SquaredButton(
                backgroundColor = Color.Black.copy(alpha = 0.2f),
                resource = R.drawable.drop_down_icon,
                onClick = {  })
        }

        NavigationBar(
            title = "Navigation bar",
            showBackButton = true,
            subtitle = "With buttons"){
            SquaredButton(
                backgroundColor = Color.Black.copy(alpha = 0.2f),
                resource = R.drawable.drop_down_icon,
                onClick = {  })
        }

        NavigationBar(
            title = "Navigation bar",
            showBackButton = true,
            subtitle = "With buttons"){
            SquaredButton(
                backgroundColor = Color.Black.copy(alpha = 0.2f),
                resource = R.drawable.drop_down_icon,
                onClick = {  })

            SquaredButton(
                backgroundColor = Color.Black.copy(alpha = 0.2f),
                resource = R.drawable.drop_down_icon,
                onClick = {  })
        }

    }
}