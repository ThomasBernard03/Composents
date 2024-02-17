package fr.thomasbernard03.sample.presentation.buttons

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fr.thomasbernard03.sample.R
import fr.thomasbernard03.composents.buttons.OutlinedButton
import fr.thomasbernard03.composents.buttons.PrimaryButton
import fr.thomasbernard03.composents.buttons.PrimaryButton2
import fr.thomasbernard03.composents.buttons.SquaredButton
import fr.thomasbernard03.sample.ui.theme.SampleTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

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
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(top = 12.dp)
                .padding(horizontal = 12.dp)
        ) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Primary button",
                style = MaterialTheme.typography.labelLarge)

            var primaryButtonLoading by remember { mutableStateOf(false) }
            val scope = rememberCoroutineScope()

            PrimaryButton(
                loading = primaryButtonLoading,
                text = "Default primary button",
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    primaryButtonLoading = true
                    scope.launch {
                        delay(2000)
                        primaryButtonLoading = false
                    }
                })

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
                modifier = Modifier.fillMaxWidth().padding(top = 12.dp),
                text = "PrimaryButton2",
                style = MaterialTheme.typography.labelLarge)

            var primaryButton2Loading by remember { mutableStateOf(false) }

            PrimaryButton2(
                loading = primaryButton2Loading,
                text = "Default primary button",
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    primaryButton2Loading = true
                    scope.launch {
                        delay(2000)
                        primaryButton2Loading = false
                    }
                })

            PrimaryButton2(
                text = "Disabled primary button",
                modifier = Modifier.fillMaxWidth(),
                onClick = {},
                enabled = false)

            PrimaryButton2(
                text = "Loading primary button",
                modifier = Modifier.fillMaxWidth(),
                onClick = {},
                loading = true)

            Text(
                text = "Outlined button",
                style = MaterialTheme.typography.labelLarge,
                modifier = Modifier.padding(top = 12.dp).fillMaxWidth())

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
                modifier = Modifier.padding(top = 12.dp).fillMaxWidth())
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