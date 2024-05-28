package com.example.tutorial_compose_adaptive_layoout.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.tutorial_compose_adaptive_layoout.ui.theme.TutorialComposeAdaptiveLayooutTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TutorialComposeAdaptiveLayooutTheme {
                AdaptiveApp()
            }
        }
    }
}