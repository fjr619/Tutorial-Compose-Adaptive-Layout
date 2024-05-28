package com.example.tutorial_compose_adaptive_layoout.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Quote(
    val quote : String,
    val author : String
): Parcelable