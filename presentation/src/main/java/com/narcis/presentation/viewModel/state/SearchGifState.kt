package com.narcis.presentation.viewModel.state

import com.narcis.presentation.model.SearchGif

data class SearchGifState(
    val isLoading: Boolean = false,
    val searchGif: List<SearchGif> = listOf(),
    val error: String = "",
    val isRefreshing: Boolean = false,
    val searchQuery: String = ""
)
