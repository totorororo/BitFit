package com.example.bitfit

import androidx.annotation.Keep
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Keep
@Serializable
data class Item(
    @SerialName("itemTitle")
    val title: String,
    @SerialName("itemValue")
    val value: String
) : java.io.Serializable