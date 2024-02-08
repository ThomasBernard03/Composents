package fr.thomasbernard03.composents

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun PrimaryButton(
    text : String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    loading : Boolean = false,
    onClick: () -> Unit
) {
    Button(
        onClick = {
            if (!loading) {
                onClick()
            }
        },
        modifier = modifier.height(48.dp),
        enabled = enabled,
        shape = RoundedCornerShape(6.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary
        )
    ) {
        if (loading) {
            CircularProgressIndicator(color = Color.White, modifier = Modifier
                .height(25.dp)
                .width(25.dp), strokeWidth = 3.dp)
        }
        else {
            Text(
                text.uppercase(),
                textAlign = TextAlign.Center,
                color = Color.White
            )
        }
    }
}