package fr.thomasbernard03.sample.presentation.textfields

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fr.thomasbernard03.composents.textfields.DropDown
import fr.thomasbernard03.composents.textfields.DropDownWithSearch
import fr.thomasbernard03.composents.textfields.TextField
import fr.thomasbernard03.sample.R
import fr.thomasbernard03.sample.ui.theme.SampleTheme

@Composable
fun TextFieldsScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "Default text field",
            style = MaterialTheme.typography.labelLarge)

        var firstTextFieldText by remember { mutableStateOf("") }
        TextField(
            modifier = Modifier.fillMaxWidth(),
            text = firstTextFieldText,
            placeholder = "Enter text",
            onTextChange = { firstTextFieldText = it },)


        var secondTextFieldText by remember { mutableStateOf("") }
        TextField(
            modifier = Modifier.fillMaxWidth(),
            text = secondTextFieldText,
            placeholder = "Text field with trailing icon",
            onTextChange = { secondTextFieldText = it },
            trailingIcon = {
                Icon(painter = painterResource(id = R.drawable.edit), contentDescription = "edit")
            })

        TextField(
            modifier = Modifier.fillMaxWidth(),
            readOnly = true,
            text = "Readonly text field",
            placeholder = "Placeholder")

        Text(
            text = "Default drop down",
            style = MaterialTheme.typography.labelLarge)

        val items = listOf("Item 1", "Item 2", "Item 3")
        var selectedItem by remember { mutableStateOf("") }

        DropDown(
            modifier = Modifier.fillMaxWidth(),
            placeholder = "Select an item",
            selectedItem = selectedItem,
            items = items,
            itemSelected = {
                selectedItem = it
            })


        Text(
            text = "Default drop down",
            style = MaterialTheme.typography.labelLarge)

        val itemsDropDownWithSearch = listOf("Item 1", "Item 2", "Item 3")
        var query by remember { mutableStateOf("") }


        DropDownWithSearch(
            modifier = Modifier.fillMaxWidth(),
            placeholder = "Search an item",
            query = query,
            onQueryChange = { query = it },
            items = itemsDropDownWithSearch.filter { it.contains(query, ignoreCase = true) },
            itemSelected = {
                query = it
            })
    }
}
@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun TextFieldsScreenPreview() {
    SampleTheme {
        Surface {
            TextFieldsScreen()
        }
    }
}