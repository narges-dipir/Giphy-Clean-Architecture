package com.narcis.data.mapper

import com.github.davidepanidev.kotlinextensions.deserializeJsonFileFromSystemResources
import com.github.davidepanidev.kotlinextensions.utils.serialization.SerializationManager
import com.github.davidepanidev.kotlinextensions.utils.serialization.gson.GsonSerializationManager
import com.narcis.data.GIF_OBJECT_ONE
import com.narcis.data.GIF_OBJECT_TWO
import com.narcis.data.model.random.RandomGif
import com.narcis.data.model.random.RandomGifResponse
import com.narcis.data.model.search.GiphyPagingResponse
import com.narcis.data.model.search.SearchGif
import org.junit.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

class GifMapperKtTest {
    private val deserializer: SerializationManager = GsonSerializationManager()
    private val giphySearchResponse: GiphyPagingResponse =
        GIF_OBJECT_ONE.deserializeJsonFileFromSystemResources(deserializer)
    private val giphyRandomResponse: RandomGifResponse =
        GIF_OBJECT_TWO.deserializeJsonFileFromSystemResources(deserializer)

    @Test
    fun `test GifObject mapper function to SearchGif`() {
        val gifSearchResponse = giphySearchResponse.gifObjects // .map { it.mapToSearchGif() }
        val expectedResponse = gifSearchResponse.map {
            SearchGif(
                id = it.id,
                url = it.images?.original?.url,
                downSizedUrl = it.images?.downsizedMedium?.url,
                title = it.title,
                rating = it.rating,
            )
        }
        val actualSearchResponse = gifSearchResponse.map { it.mapToSearchGif() }
        expectThat(actualSearchResponse).isEqualTo(expectedResponse)
    }

    @Test
    fun `test RandomGifResponse mapper to RandomGif`() {
        val gifRandomResponse = giphyRandomResponse
        val expectedResponse = with(gifRandomResponse) {
            RandomGif(
                url = this.randomGifData.images?.original?.url,
                title = this.randomGifData.title ?: "Gif Title",
                id = this.randomGifData.id ?: "",
                rating = this.randomGifData.rating ?: "pg",
            )
        }

        val actualResponse = gifRandomResponse.mapToRandomGif()
        expectThat(actualResponse).isEqualTo(expectedResponse)
    }
}
