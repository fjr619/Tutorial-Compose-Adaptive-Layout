package com.example.tutorial_compose_adaptive_layoout.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.tutorial_compose_adaptive_layoout.data.Quote

@Composable
fun ListScreen(
    modifier: Modifier = Modifier,
    paddingValues: PaddingValues,
    items: List<Quote>,
    onItemClick: (Quote) -> Unit
) {
    LazyColumn(
        modifier = modifier.padding(paddingValues),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        items(
            items = items,
            key = { it.quote }
        ) {
            ListItem(
                colors = ListItemDefaults.colors(
                    containerColor = if (isSystemInDarkTheme()) Color.White.copy(0.05f) else Color.Black.copy(
                        0.05f
                    )
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        onItemClick(it)
                    },
                headlineContent = { Text(text = it.quote) },
                supportingContent = { Text(text = it.author) })
        }
    }
}