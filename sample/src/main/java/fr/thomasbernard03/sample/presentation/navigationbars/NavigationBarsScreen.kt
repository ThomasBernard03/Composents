package fr.thomasbernard03.sample.presentation.navigationbars

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fr.thomasbernard03.composents.navigationbars.NavigationBar
import fr.thomasbernard03.composents.buttons.SquaredButton
import fr.thomasbernard03.composents.navigationbars.NavigationBarDefaults
import fr.thomasbernard03.sample.R
import fr.thomasbernard03.sample.ui.theme.SampleTheme

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
                backgroundColor = NavigationBarDefaults.buttonBackgroundColor,
                resource = R.drawable.edit,
                onClick = {  })
        }

        NavigationBar(
            title = "Navigation bar",
            showBackButton = true,
            subtitle = "With buttons"){
            SquaredButton(
                backgroundColor = NavigationBarDefaults.buttonBackgroundColor,
                resource = R.drawable.bluetooth,
                onClick = {  })
        }

        NavigationBar(
            title = "Navigation bar",
            showBackButton = true,
            subtitle = "With buttons"){
            SquaredButton(
                backgroundColor = NavigationBarDefaults.buttonBackgroundColor,
                resource = fr.thomasbernard03.sample.R.drawable.bluetooth,
                onClick = {  })

            SquaredButton(
                backgroundColor = NavigationBarDefaults.buttonBackgroundColor,
                resource = R.drawable.discount,
                onClick = {  })
        }
    }
}

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun NavigationBarsScreenPreview() {
    SampleTheme {
        Surface {
            NavigationBarsScreen()
        }
    }
}