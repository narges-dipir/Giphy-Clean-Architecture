package com.narcis.presentation.components

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.narcis.presentation.model.RandomGif
import com.narcis.presentation.theme.ApplicationTheme
import com.narcis.presentation.theme.PicnicTestTheme
import com.narcis.presentation.theme.Shadow7
import com.narcis.presentation.utiles.Constants
import com.narcis.presentation.utiles.loadGif
import com.narcis.presentation.utiles.parsPgNumber
import kotlin.math.roundToInt

@Composable
fun SingleGifView(randomGif: RandomGif?, context: Context) {
    Column {
        val requestBuilder = loadGif(
            context = context,
            imageUrl = randomGif?.url ?: Constants.Place_Holder_Random_Gif_Url,
            thumbnailUrl = randomGif?.downsizedUrl ?: Constants.Place_Holder_Random_Gif_Url,
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
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column(modifier = Modifier.weight(0.9f)) {
                Text(
                    text = randomGif?.title.toString(),
                    color = ApplicationTheme.colors.textPrimary,
                    fontStyle = FontStyle.Normal,
                    modifier = Modifier.padding(start = 8.dp, top = 12.dp, bottom = 12.dp),
                )
                Text(
                    text = randomGif?.url.toString(),
                    color = Shadow7,
                    fontStyle = FontStyle.Italic,
                    modifier = Modifier.padding(start = 8.dp, top = 12.dp, bottom = 12.dp),
                )
            }
            CircleTextView(
                modifier = Modifier
                    .size(130.dp)
                    .weight(0.5f),
                text = ("+" + randomGif?.rating?.parsPgNumber()) ?: "?",
            )
        }
    }
}

@Preview
@Composable
private fun Preview() {
    PicnicTestTheme {
        SingleGifView(
            randomGif = RandomGif(
                url = "https://media2.giphy.com/media/QZnfSw3fJT46mTiDEX/giphy.gif?cid=6df7b0fe1qoaalke0nrfor74jtit8gm75xcgkmc2bjepjl40&ep=v1_gifs_random&rid=giphy.gif&ct=g",
                title = "GIF by joelremygif",
                id = "2aJWp78LSQiy5k7PLa",
                rating = "pg",
            ),
            context = LocalContext.current,
        )
    }
}
