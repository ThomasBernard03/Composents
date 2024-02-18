package fr.thomasbernard03.composents.textfields

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import fr.thomasbernard03.composents.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun <T>DropDown(
    modifier : Modifier = Modifier,
    label : (T) -> String = { it.toString() },
    placeholder: String,
    selectedItem : T?,
    items: List<T>,
    itemSelected : (T) -> Unit,
) {
    var expanded by rememberSaveable { mutableStateOf(false) }
    val rotationAngle by animateFloatAsState(targetValue = if (expanded) 180f else 0f, label = "")

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded },
    ){
        TextField(
            modifier = modifier.menuAnchor(),
            readOnly = true,
            text = if (selectedItem != null) label(selectedItem) else "",
            placeholder = placeholder,
            trailingIcon = {
                Icon(
                    modifier = Modifier.rotate(rotationAngle),
                    painter = painterResource(R.drawable.drop_down_icon),
                    contentDescription = "Text field icon")
            })

        if (items.isNotEmpty()){
            ExposedDropdownMenu(
                expanded = expanded,
                modifier = Modifier.background(MaterialTheme.colorScheme.background),
                onDismissRequest = { expanded = false },
            ) {
                items.forEach { selectionOption ->
                    DropdownMenuItem(
                        text = { Text(label(selectionOption)) },
                        onClick = {
                            expanded = false
                            itemSelected(selectionOption)
                        },
                    )
                }
            }
        }
    }
}