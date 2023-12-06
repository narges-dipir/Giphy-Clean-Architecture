package com.narcis.presentation.components

import android.content.Context
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.unit.dp
import androidx.test.core.app.ApplicationProvider
import com.narcis.presentation.model.RandomGif
import com.narcis.presentation.theme.GiphyTestTheme
import com.narcis.presentation.utiles.Constants
import com.narcis.presentation.utiles.loadGif
import org.junit.Rule
import org.junit.Test

class GifViewKtTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private val testContext: Context = ApplicationProvider.getApplicationContext()

    @Test
    fun when_displayingBaseEmptyState_should_displayExpectedContent() {
        val randomGif = RandomGif(
            url = "https://media2.giphy.com/media/QZnfSw3fJT46mTiDEX/giphy.gif?cid=6df7b0fe1qoaalke0nrfor74jtit8gm75xcgkmc2bjepjl40&ep=v1_gifs_random&rid=giphy.gif&ct=g",
            title = "GIF by joelremygif",
            id = "2aJWp78LSQiy5k7PLa",
            rating = "pg",
        )
        val requestBuilder = loadGif(
            context = testContext,
            imageUrl = randomGif.url ?: Constants.Place_Holder_Random_Gif_Url,
            thumbnailUrl = randomGif.downsizedUrl ?: Constants.Place_Holder_Random_Gif_Url,
        )
        composeTestRule.setContent {
            GiphyTestTheme {
                GifView(
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1.0f)
                        .padding(32.dp),
                    randomGif = randomGif,
                    requestBuilder = requestBuilder,
                )
            }
            composeTestRule.apply {
                onNodeWithText(randomGif.url!!).assertIsDisplayed()
            }
        }
    }
}
