package fr.thomasbernard03.sample.presentation.buttons

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fr.thomasbernard03.sample.R
import fr.thomasbernard03.composents.buttons.OutlinedButton
import fr.thomasbernard03.composents.buttons.PrimaryButton
import fr.thomasbernard03.composents.buttons.SquaredButton
import fr.thomasbernard03.sample.ui.theme.SampleTheme

@Composable
fun ButtonsScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier
                .padding(top = 12.dp)
                .padding(horizontal = 12.dp)
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
        }

        LazyRow(
            contentPadding = PaddingValues(horizontal = 12.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            item {
                SquaredButton(resource = R.drawable.edit, onClick = {})
            }
            item {
                SquaredButton(
                    resource = R.drawable.edit,
                    onClick = {},
                    backgroundColor = Color.Black)
            }
            item {
                SquaredButton(
                    resource = R.drawable.hand,
                    onClick = {},
                    color = Color.White,
                    backgroundColor = Color.Red)
            }
            item {
                SquaredButton(
                    resource = R.drawable.discount,
                    onClick = {},
                    backgroundColor = Color.Yellow,
                    color = Color.Black)
            }
            item {
                SquaredButton(
                    resource = R.drawable.bluetooth,
                    backgroundColor = Color.Blue,
                    onClick = {})
            }
        }
    }
}

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun ButtonsScreenPreview() {
    SampleTheme {
        Surface {
            ButtonsScreen()
        }
    }
}