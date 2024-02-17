package fr.thomasbernard03.composents.buttons

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.layout.PaddingValues
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
fun PrimaryButton2(
    text : String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    loading : Boolean = false,
    onClick: () -> Unit
) {
    val height = 48.dp

    Button(
        onClick = {
            if (!loading)
                onClick()
        },
        modifier = Modifier
            .height(height)
            .then(
                if (loading)
                    Modifier.width(height)
                else
                    Modifier
            )
            .then(modifier),
        contentPadding = PaddingValues(0.dp),
        enabled = enabled,
        shape = RoundedCornerShape(if (loading) height/2 else 6.dp),
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