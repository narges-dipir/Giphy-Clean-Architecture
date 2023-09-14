package com.narcis.presentation.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.narcis.presentation.utiles.Constants.RATING
import com.narcis.presentation.utiles.Constants.TITLE
import com.narcis.presentation.utiles.Constants.URL
import com.narcis.presentation.viewModel.state.SingleSearchResultGifState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SingleSearchResultGifViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
) : ViewModel() {
    var state by mutableStateOf(SingleSearchResultGifState())
    init {
        savedStateHandle.get<String>(URL)?.let {
            state = state.copy(url = it)
        }
        savedStateHandle.get<String>(TITLE)?.let {
            state = state.copy(title = it)
        }
        savedStateHandle.get<String>(RATING).let {
            state = state.copy(rating = it)
        }
    }
}
