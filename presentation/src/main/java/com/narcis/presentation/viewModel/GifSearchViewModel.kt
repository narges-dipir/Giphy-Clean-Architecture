package com.narcis.presentation.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.narcis.domain.common.Result
import com.narcis.domain.useCase.SearchGifUseCase
import com.narcis.presentation.mapper.mapToSearchGif
import com.narcis.presentation.utiles.Constants.Delay_Between_Typing
import com.narcis.presentation.viewModel.event.SearchEvent
import com.narcis.presentation.viewModel.state.SearchGifState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GifSearchViewModel @Inject constructor(
    private val searchGifUseCase: SearchGifUseCase,
) : ViewModel() {
    private var searchJob: Job? = null
    var state by mutableStateOf(SearchGifState())

    fun onEvent(event: SearchEvent) {
        when (event) {
            is SearchEvent.OnSearchQueryChange -> {
                state = state.copy(searchQuery = event.query)
                searchJob?.cancel()
                searchJob = viewModelScope.launch {
                    delay(Delay_Between_Typing)
                    search()
                }
            }

            SearchEvent.Refresh -> TODO()
        }
    }

    private fun search() {
        viewModelScope.launch {
            searchGifUseCase(state.searchQuery).collect { result ->
                when (result) {
                    is com.narcis.domain.common.Result.Error -> {
                        state = state.copy(isLoading = false, error = result.exception.toString())
                    }

                    Result.Loading -> {
                        state = state.copy(isLoading = true)
                    }

                    is Result.Success -> {
                        state = state.copy(
                            isLoading = false,
                            searchGif = result.data.map { it.mapToSearchGif() },
                        )
                    }
                }
            }
        }
    }
}
