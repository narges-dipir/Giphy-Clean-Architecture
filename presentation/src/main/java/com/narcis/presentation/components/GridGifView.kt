package com.narcis.presentation.components

import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.narcis.presentation.model.RandomGif
import com.narcis.presentation.utiles.Constants.Place_Holder_Random_Gif_Url
import com.narcis.presentation.utiles.loadGif
import com.narcis.presentation.viewModel.state.SearchGifState

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun GridGifView(
    navController: NavController?,
    gifItems: SearchGifState,
    modifier: Modifier = Modifier,
) {
    val context = LocalContext.current
    Column {
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(12.dp),
        ) {
            if (gifItems.searchGif.isEmpty()) {
                // show loading
            }
            items(
                items = gifItems.searchGif,
                key = { item -> item.url!! },
            ) { item ->
                BoxWithConstraints(
                    modifier = modifier.animateItemPlacement(
                        animationSpec = tween(durationMillis = 444),
                    ),
                ) {
                    val requestBuilder = loadGif(
                        context = context,
                        imageUrl = item.url ?: Place_Holder_Random_Gif_Url,
                        thumbnailUrl = item.downSizedUrl ?: Place_Holder_Random_Gif_Url,
                    )
                    GifView(
                        modifier = Modifier
                            .fillMaxWidth()
                            .aspectRatio(1.0f)
                            .padding(12.dp),
                        randomGif =
                        RandomGif(
                            id = item.id ?: "",
                            url = item.url,
                            downsizedUrl = item.downSizedUrl,
                            title = item.title ?: "",
                            rating = item.rating ?: "",
                        ),
                        requestBuilder = requestBuilder,
                        navController = navController,
                    )
                }
            }
        }
    }
}
