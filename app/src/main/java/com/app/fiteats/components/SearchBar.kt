package com.app.fiteats.components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemColors
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.app.fiteats.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBarM3(){

    var query by remember { mutableStateOf("") }
    var active by remember { mutableStateOf(false) }

    val searchHistory = listOf("Chicken", "Meat", "Fish", "Pork")

    SearchBar(
        query = query,
        onQueryChange = { query = it },
        onSearch = { newQuery ->
            println("Performing search n query: $newQuery")
        },
        active = active,
        onActiveChange = { active = it },
        placeholder = {
            Text(text = "Search food", color = Color.Gray)
        },
        leadingIcon = {
            Icon(imageVector = Icons.Filled.Search, contentDescription = "Search", tint = Color.Gray)
        },
        trailingIcon = if (active){
            {
                IconButton(onClick = { if (query.isNotEmpty()) query = "" else active = false }) {
                    Icon(imageVector = Icons.Filled.Close, contentDescription = "Close")
                }
            }
        } else null,
        colors = SearchBarDefaults.colors(
            containerColor = Color.LightGray,
            inputFieldColors = TextFieldDefaults.textFieldColors(
                containerColor = Color.LightGray,
            )
        )
    ) {
        searchHistory.takeLast(3).forEach { item ->
            ListItem(
                modifier = Modifier.clickable { query = item },
                headlineContent = { Text(text = item) },
                leadingContent = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_history),
                        contentDescription = null
                    )
                },
                colors = ListItemDefaults.colors(
                    containerColor = Color.LightGray
                )
            )
        }
    }
}