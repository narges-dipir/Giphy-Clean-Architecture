package com.narcis.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.load.resource.gif.GifDrawable
import com.narcis.presentation.model.RandomGif
import com.narcis.presentation.navigation.Navigation
import com.narcis.presentation.theme.GiphyTestTheme
import com.narcis.presentation.theme.Shadow0
import com.narcis.presentation.theme.Shadow2
import com.narcis.presentation.utiles.Constants.Place_Holder_Random_Gif_Url
import com.narcis.presentation.utiles.loadGif
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.glide.GlideImage
import com.skydoves.landscapist.glide.GlideRequestType
import com.skydoves.landscapist.glide.LocalGlideRequestBuilder
import java.net.URLEncoder
import java.nio.charset.StandardCharsets
import kotlin.math.roundToInt

@Composable
fun GifView(
    modifier: Modifier = Modifier,
    colors: List<Color> = listOf(Shadow2, Shadow0),
    randomGif: RandomGif?,
    requestBuilder: RequestBuilder<GifDrawable>,
    navController: NavController? = null,
) {
    val brush = Brush.horizontalGradient(colors = colors)
    Box(
        modifier = modifier
            .background(
                brush = brush,
                alpha = 0.8f,
                shape = RoundedCornerShape(16.dp),
            ),
        contentAlignment = Alignment.Center,
    ) {
        CompositionLocalProvider(LocalGlideRequestBuilder provides requestBuilder) {
            GlideImage(
                imageModel = { randomGif?.url },
                glideRequestType = GlideRequestType.GIF,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp)
                    .clip(RoundedCornerShape(20))
                    .semantics { contentDescription = "random gif" }
                    .clickable {
                        println(" th title ${randomGif?.title} ${randomGif?.rating}")
                        navController?.navigate(
                            Navigation.SingleGif.route + "/${
                                URLEncoder.encode(
                                    randomGif?.url,
                                    StandardCharsets.UTF_8.toString(),
                                )
                            }" +
                                "/${if (randomGif?.title != "") randomGif?.title else "Title Gif"}" +
                                "/${randomGif?.rating}",
                        )
                    },
                imageOptions = ImageOptions(contentScale = ContentScale.Crop),
                loading = {
                    Box(modifier = Modifier.matchParentSize()) {
                        CircularProgressIndicator(
                            modifier = Modifier.align(Alignment.Center),
                        )
                    }
                },
            )
        }
    }
}

@Preview
@Composable
private fun Preview() {
    GiphyTestTheme {
        val context = LocalContext.current
        val randomGif = RandomGif(
            url = "https://media2.giphy.com/media/QZnfSw3fJT46mTiDEX/giphy.gif?cid=6df7b0fe1qoaalke0nrfor74jtit8gm75xcgkmc2bjepjl40&ep=v1_gifs_random&rid=giphy.gif&ct=g",
            title = "GIF by joelremygif",
            id = "2aJWp78LSQiy5k7PLa",
            rating = "pg",
        )
        val requestBuilder = loadGif(
            context = context,
            imageUrl = randomGif.url ?: Place_Holder_Random_Gif_Url,
            thumbnailUrl = randomGif.downsizedUrl ?: Place_Holder_Random_Gif_Url,
            override = 135.dp.value.roundToInt(),
        )
        GifView(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1.0f)
                .padding(32.dp),
            randomGif = randomGif,
            requestBuilder = requestBuilder,
        )
    }
}
