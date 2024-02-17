package fr.thomasbernard03.composents.presentation.buttons

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import fr.thomasbernard03.composents.R
import fr.thomasbernard03.composents.buttons.OutlinedButton
import fr.thomasbernard03.composents.buttons.PrimaryButton
import fr.thomasbernard03.composents.buttons.SquaredButton

@Composable
fun ButtonsScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "Primary button",
            style = MaterialTheme.typography.labelLarge)

        PrimaryButton(
            text = "Default primary button",
            modifier = Modifier.fillMaxWidth(),
            onClick = {})

        PrimaryButton(
            text = "Disabled primary button",
            modifier = Modifier.fillMaxWidth(),
            onClick = {},
            enabled = false)

        PrimaryButton(
            text = "Loading primary button",
            modifier = Modifier.fillMaxWidth(),
            onClick = {},
            loading = true)

        Text(
            text = "Outlined button",
            style = MaterialTheme.typography.labelLarge,
            modifier = Modifier.padding(top = 12.dp))

        OutlinedButton(
            text = "Default outlined button",
            modifier = Modifier.fillMaxWidth(),
            onClick = {})

        OutlinedButton(
            text = "Disabled outlined button",
            modifier = Modifier.fillMaxWidth(),
            enabled = false,
            onClick = {})

        OutlinedButton(
            text = "Loading outlined button",
            modifier = Modifier.fillMaxWidth(),
            loading = true,
            onClick = {})

        Text(
            text = "Squared button",
            style = MaterialTheme.typography.labelLarge,
            modifier = Modifier.padding(top = 12.dp))

        Row(
            modifier = Modifier.horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            SquaredButton(resource = R.drawable.arrow, onClick = {})
            SquaredButton(resource = R.drawable.arrow, onClick = {})
            SquaredButton(resource = R.drawable.arrow, onClick = {})
            SquaredButton(resource = R.drawable.arrow, onClick = {})
            SquaredButton(resource = R.drawable.arrow, onClick = {})
            SquaredButton(resource = R.drawable.arrow, onClick = {})
            SquaredButton(resource = R.drawable.arrow, onClick = {})
            SquaredButton(resource = R.drawable.arrow, onClick = {})

        }

    }
}