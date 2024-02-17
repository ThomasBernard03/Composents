package fr.thomasbernard03.composents.buttons

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun OutlinedButton(
    text: String,
    modifier : Modifier = Modifier,
    enabled : Boolean = true,
    loading : Boolean = false,
    color : Color = MaterialTheme.colorScheme.primary,
    onClick: () -> Unit
){
    Button(
        enabled = enabled,
        onClick = {
            if (!loading) {
                onClick()
            }
        },
        modifier = modifier.height(48.dp),
        shape = RoundedCornerShape(6.dp),
        border = BorderStroke(width = 1.dp, color = if (enabled) color else LightGray),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
            disabledContainerColor = Color.Transparent,
            contentColor = color),
    ) {
        if (loading) {
            CircularProgressIndicator(color = MaterialTheme.colorScheme.primary, modifier = Modifier
                .height(25.dp)
                .width(25.dp), strokeWidth = 3.dp)
        }
        else {
            Text(
                text.uppercase(),
                textAlign = TextAlign.Center
            )
        }
    }
}
