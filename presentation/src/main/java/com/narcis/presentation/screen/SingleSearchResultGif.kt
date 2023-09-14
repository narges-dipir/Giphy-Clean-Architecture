package com.narcis.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.narcis.presentation.components.SearchBar
import com.narcis.presentation.components.SingleGifView
import com.narcis.presentation.model.RandomGif
import com.narcis.presentation.theme.ApplicationTheme
import com.narcis.presentation.utiles.Constants
import com.narcis.presentation.utiles.loadGif
import com.narcis.presentation.viewModel.SingleSearchResultGifViewModel

@Composable
fun SingleSearchResultGifScreen(
    navController: NavController,
    singleSearchResultGifViewModel: SingleSearchResultGifViewModel = hiltViewModel(),
) {
    val state = singleSearchResultGifViewModel.state
    val context = LocalContext.current
    val requestBuilder = loadGif(
        context = context,
        imageUrl = state.url ?: Constants.Place_Holder_Random_Gif_Url,
        thumbnailUrl = state.url ?: Constants.Place_Holder_Random_Gif_Url,
    )
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color = ApplicationTheme.colors.uiBackground),
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {
        SearchBar(
            textValue = state.title ?: "",
            isTrailingIconVisible = false,
            placeholderText = "search...",
            showSearchView = false,
            haseTitle = true,
            naveController = navController,
        )
        Spacer(modifier = Modifier.height(8.dp))
        SingleGifView(
            randomGif = RandomGif(
                id = "",
                url = state.url,
                downsizedUrl = state.url,
                title = state.title ?: "Gif Title",
                rating = state.rating ?: "",
            ),
            context = context,
        )
    }
}
