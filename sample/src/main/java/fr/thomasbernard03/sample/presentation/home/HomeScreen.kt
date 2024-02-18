package fr.thomasbernard03.sample.presentation.home

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import fr.thomasbernard03.composents.buttons.PrimaryButton
import fr.thomasbernard03.sample.ui.theme.SampleTheme

@Composable
fun HomeScreen(navController: NavController){

    fun navigate(route : String){
        navController.navigate(route){
            launchSingleTop = true
            popUpTo("home")
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        PrimaryButton(
            text = "Buttons",
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                navigate("buttons")
            })

        PrimaryButton(
            text = "Textfields",
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                navigate("textfields")
            })

        PrimaryButton(
            text = "Navigation bars",
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                navigate("navigationbars")
            })
    }
}

@Composable
@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
fun HomeScreenPreview(){
    SampleTheme {
        Surface {
            val navController = rememberNavController()
            HomeScreen(navController = navController)
        }
    }
}