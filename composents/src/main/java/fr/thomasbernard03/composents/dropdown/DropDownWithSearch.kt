package fr.thomasbernard03.composents.dropdown

import androidx.compose.foundation.background
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import fr.thomasbernard03.composents.TextField

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun <T>DropDownWithSearch(
    modifier : Modifier = Modifier,
    query : String,
    onQueryChange: (String) -> Unit,
    label : (T) -> String = { it.toString() },
    placeholder: String,
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
            onTextChange = onQueryChange,
            text = query,
            placeholder = placeholder)

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