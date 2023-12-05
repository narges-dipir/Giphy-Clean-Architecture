package com.narcis.presentation.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.narcis.domain.common.Result
import com.narcis.domain.common.data
import com.narcis.domain.useCase.RandomGifUseCase
import com.narcis.presentation.mapper.mapToRandomGif
import com.narcis.presentation.utiles.Constants.Random_Gif_TimOut
import com.narcis.presentation.viewModel.event.RandomGifEvent
import com.narcis.presentation.viewModel.state.RandomGifState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RandomGifViewModel @Inject constructor(
    private val randomGifUseCase: RandomGifUseCase,
) : ViewModel() {
    private var searchJob: Job? = null
    var state by mutableStateOf(RandomGifState())

    init {
        getNextRandomGif()
    }
    fun onEvent(event: RandomGifEvent) {
        when (event) {
            is RandomGifEvent.AutoTrigger -> {
                if (event.load) {
                    state = state.copy(startAutoLoading = true)
                } else {
                    state = state.copy(startAutoLoading = false)
                }
            }

            else -> {}
        }
    }

    private fun getNextRandomGif() {
        searchJob?.cancel()
        searchJob = viewModelScope.launch {
            while (state.startAutoLoading) {
                randomGifUseCase(Unit).collect { result ->
                    when (result) {
                        is Result.Error -> {
                            state =
                                state.copy(isLoading = false, error = result.exception.toString())
                        }

                        Result.Loading -> {
                            state = state.copy(isLoading = true)
                        }

                        is Result.Success -> {
                            state =
                                state.copy(
                                    isLoading = false,
                                    randomGif = result.data.mapToRandomGif(),
                                )
                        }

                        else -> {}
                    }
                }
                delay(Random_Gif_TimOut)
            }
        }
    }
}
