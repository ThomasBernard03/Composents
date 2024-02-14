package fr.thomasbernard03.composents

import androidx.compose.foundation.background
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun <T>DropDown(
    modifier : Modifier = Modifier,
    placeholder: String,
    selectedItem : T?,
    items: List<T>,
    itemSelected : (T) -> Unit,
) {
    var expanded by rememberSaveable { mutableStateOf(false) }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded },
    ){
        TextField(
            modifier = modifier.menuAnchor(),
            readOnly = true,
            text = selectedItem?.toString() ?: "",
            placeholder = placeholder)

        if (items.isNotEmpty()){
            ExposedDropdownMenu(
                expanded = expanded,
                modifier = Modifier.background(MaterialTheme.colorScheme.background),
                onDismissRequest = { expanded = false },
            ) {
                items.forEach { selectionOption ->
                    DropdownMenuItem(
                        text = { Text(selectionOption.toString()) },
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