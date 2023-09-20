package com.narcis.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.narcis.presentation.components.GridGifView
import com.narcis.presentation.components.SearchBar
import com.narcis.presentation.components.SingleGifView
import com.narcis.presentation.theme.ApplicationTheme
import com.narcis.presentation.theme.GiphyTestTheme
import com.narcis.presentation.viewModel.GifSearchViewModel
import com.narcis.presentation.viewModel.RandomGifViewModel
import com.narcis.presentation.viewModel.event.RandomGifEvent
import com.narcis.presentation.viewModel.event.SearchEvent
import com.narcis.presentation.viewModel.state.RandomGifState
import com.narcis.presentation.viewModel.state.SearchGifState

@Composable
fun HomeScreen(
    navController: NavController? = null,
    randomGifViewModel: RandomGifViewModel = hiltViewModel(),
    searchViewModel: GifSearchViewModel = hiltViewModel(),
) {
    var title by rememberSaveable {
        mutableStateOf("Random Selected Gif")
    }
    var randomSingleGifVisibility by remember {
        mutableStateOf(true)
    }
    var gridViewGifVisibility by remember {
        mutableStateOf(false)
    }
    val randomGifState: RandomGifState = randomGifViewModel.state
    val searchGifState: SearchGifState = searchViewModel.state

    if (searchGifState.searchQuery != "") {
        randomGifViewModel.onEvent(RandomGifEvent.AutoTrigger(load = false))
        randomSingleGifVisibility = false
        gridViewGifVisibility = true
        title = "Search Result"
    } else if (searchGifState.searchQuery.isEmpty()) {
        randomGifViewModel.onEvent(RandomGifEvent.AutoTrigger(load = true))
        randomSingleGifVisibility = true
        gridViewGifVisibility = false
        title = "Random Selected Gif"
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color = ApplicationTheme.colors.uiBackground),
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {
        SearchBar(
            textValue = searchGifState.searchQuery,
            valueChange = {
                searchViewModel
                    .onEvent(SearchEvent.OnSearchQueryChange(query = it))
            },
            isTrailingIconVisible = false,
            placeholderText = "search...",
            naveController = null,
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
        ) {
            Text(
                text = title,
                fontSize = 18.sp,
                textAlign = TextAlign.Left,
                color = ApplicationTheme.colors.textPrimary,
                modifier = Modifier.padding(12.dp),
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        if (randomSingleGifVisibility) {
            SingleGifView(randomGifState.randomGif, LocalContext.current)
        }
        if (gridViewGifVisibility) {
            GridGifView(navController, searchGifState)
        }
    }
}

@Composable
@Preview
private fun Preview() {
    GiphyTestTheme {
        HomeScreen()
    }
}
