package com.example.tutorial_compose_adaptive_layoout.ui.components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.window.core.layout.WindowWidthSizeClass
import com.example.tutorial_compose_adaptive_layoout.data.Quote

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    quote: Quote,
    modifier: Modifier = Modifier,
    onBackClick : () -> Unit,
) {

    val adaptiveInfo = currentWindowAdaptiveInfo()
    val showAction = remember(adaptiveInfo) {
        adaptiveInfo.windowSizeClass.windowWidthSizeClass != WindowWidthSizeClass.EXPANDED
    }

    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(text = "DETAIL")
            },
                navigationIcon = {
                    if (showAction) {
                        IconButton(onClick = { onBackClick() }) {
                            Icon(imageVector = Icons.AutoMirrored.Default.ArrowBack, contentDescription = "")
                        }
                    }
                })
        }
    ) {  paddingValues ->
        Box(modifier = modifier.fillMaxSize().padding(paddingValues), contentAlignment = Alignment.Center) {
            Column {
                Text(text = quote.quote, style = MaterialTheme.typography.displaySmall)
                Text(text = quote.author, style = MaterialTheme.typography.bodyMedium)
            }
        }
    }

}