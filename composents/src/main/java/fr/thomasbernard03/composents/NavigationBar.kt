package fr.thomasbernard03.composents

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import fr.thomasbernard03.composents.buttons.SquaredButton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationBar(
    title : String,
    subtitle : String = "",
    showBackButton : Boolean = false,
    onBack : () -> Unit = {},
    actions : @Composable (RowScope) -> Unit = {}
){
    CenterAlignedTopAppBar(
        navigationIcon = {
            if (showBackButton){
                SquaredButton(
                    modifier = Modifier.padding(horizontal = 8.dp),
                    resource = R.drawable.arrow,
                    onClick = onBack,
                    backgroundColor = Color.Black.copy(alpha = 0.2f),
                    color = Color.White
                )
            }
        },
        title = {
            Column {
                Text(
                    text = title,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    fontSize = 18.sp,
                    fontWeight = FontWeight(700)
                )

                AnimatedVisibility(visible = subtitle.isNotEmpty()) {
                    Text(
                        text = subtitle,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        fontSize = 13.sp,
                        fontWeight = FontWeight(400)
                    )
                }
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = Color.White
        ),
        actions = {
            Row(
                modifier = Modifier.padding(horizontal = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                actions(this)
            }
        }
    )
}