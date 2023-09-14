package com.narcis.presentation.viewModel.state

import com.narcis.presentation.model.RandomGif

data class RandomGifState(
    val isLoading: Boolean = false,
    val randomGif: RandomGif? = null,
    val error: String = "",
    val searchQueryChange: String = "",
    val startAutoLoading: Boolean = true,
)
