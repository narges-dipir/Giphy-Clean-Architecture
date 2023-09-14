package com.narcis.domain.mapper

import com.narcis.data.model.random.RandomGif
import com.narcis.data.model.search.SearchGif
import com.narcis.domain.model.SearchGifResult
import org.junit.Test
import kotlin.test.assertEquals

class DataModelsMapperKtTest {

    @Test
    fun `map SearchGif in data layer to SearchGifResult in domain layer`() {
        val searchGif: SearchGif = SearchGif(
            id = "1",
            url = "https://giphy.com/gifs/AgenceLusso-football-soccer-foot-6mm6mUUExaAecMAvMq",
            downSizedUrl = "https://media3.giphy.com/media/6mm6mUUExaAecMAvMq/giphy.gif?cid=6df7b0fe2zhjvlxhkznbwoknmh3f5on4tvupzp2hs9hbib47&ep=v1_gifs_search&rid=giphy.gif&ct=g",
            title = "sample gif_title",
            rating = "pg-15"
        )
        val searchGifResult: SearchGifResult = searchGif.mapToSearchGif()
        assertEquals(searchGif.id, searchGifResult.id)
        assertEquals(searchGif.url, searchGifResult.url)
        assertEquals(searchGif.downSizedUrl, searchGifResult.downSizedUrl)
        assertEquals(searchGif.title, searchGifResult.title)
        assertEquals(searchGif.rating, searchGifResult.rating)

    }

    @Test
    fun `map random gif in data layer to RandomGifResult in domain layer`() {

        val randomGif: RandomGif = RandomGif(
            id = "1",
            url = "https://giphy.com/gifs/AgenceLusso-football-soccer-foot-6mm6mUUExaAecMAvMq",
            title = "sample gif_title",
            rating = "pg-15"
        )
        val randomGifResult = randomGif.mapToRandomGifResult()
        assertEquals(randomGif.id, randomGifResult.id)
        assertEquals(randomGif.url, randomGifResult.url)
        assertEquals(randomGif.title, randomGifResult.title)
        assertEquals(randomGif.rating, randomGifResult.rating)
    }
}