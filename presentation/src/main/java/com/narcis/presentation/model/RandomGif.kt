package com.narcis.presentation.model

data class RandomGif(
    val id: String,
    val url: String?,
    val downsizedUrl: String ? = "",
    val title: String ? = "Gif Title",
    val rating: String ? = "pg-20",
)
