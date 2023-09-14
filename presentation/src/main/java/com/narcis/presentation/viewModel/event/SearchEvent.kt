package com.narcis.presentation.viewModel.event

sealed class SearchEvent {
    object Refresh : SearchEvent()
    data class OnSearchQueryChange(val query: String) : SearchEvent()
}
