package com.example.tutorial_compose_adaptive_layoout.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

data class NavigationItemContent(
    val icon: ImageVector,
    val text: String,
)

val navigationItemList = listOf(
    NavigationItemContent(
        text = "Home",
        icon = Icons.Default.Home,
    ),
    NavigationItemContent(
        text = "Search",
        icon = Icons.Default.Search
    ),
    NavigationItemContent(
        text = "Bookmark",
        icon = Icons.Default.FavoriteBorder
    )
)