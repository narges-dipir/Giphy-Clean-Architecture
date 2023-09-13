package com.narcis.data.repository

import com.narcis.data.api.GiphyApi
import com.narcis.data.mapper.mapToRandomGif
import com.narcis.data.model.random.Data
import com.narcis.data.model.random.RandomGifResponse
import com.narcis.data.model.search.Downsized
import com.narcis.data.model.search.DownsizedMedium
import com.narcis.data.model.search.GifObject
import com.narcis.data.model.search.GiphyPagingResponse
import com.narcis.data.model.search.Images
import com.narcis.data.model.search.Original
import com.narcis.data.model.search.SearchGif
import com.narcis.data.utiles.Constants.API_KEY
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

class GifRepositoryImplTest {

    @MockK
    private lateinit var giphyApi: GiphyApi

    @MockK
    private lateinit var repository: GifRepository

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        repository = GifRepositoryImpl(giphyApi = giphyApi)
    }

    @Test
    fun `test getting single random Gif from server not empty query`(): Unit = runBlocking {
        val images = Images(
            downsized = Downsized(
                height = "444",
                width = "480",
                size = "64567",
                url = "https://media1.giphy.com/media/igOgjc5yHX0oLEpL1u/giphy.gif?cid=6df7b0feyf2kupc1kbn35fluv5satlmy7fjvmwl9siacg6jq&ep=v1_gifs_random&rid=giphy.gif&ct=g",
            ),
            downsizedLarge = null,
            downsizedMedium = DownsizedMedium(
                height = "444",
                width = "480",
                size = "64567",
                url = "https://media1.giphy.com/media/igOgjc5yHX0oLEpL1u/giphy.gif?cid=6df7b0feyf2kupc1kbn35fluv5satlmy7fjvmwl9siacg6jq&ep=v1_gifs_random&rid=giphy.gif&ct=g",
            ),
            downsizedSmall = null,
            downsizedStill = null,
            original = Original(
                height = "444",
                width = "480",
                size = "64567",
                url = "https://media1.giphy.com/media/igOgjc5yHX0oLEpL1u/giphy.gif?cid=6df7b0feyf2kupc1kbn35fluv5satlmy7fjvmwl9siacg6jq&ep=v1_gifs_random&rid=giphy.gif&ct=g",
                mp4 = "https://media1.giphy.com/media/igOgjc5yHX0oLEpL1u/giphy.mp4?cid=6df7b0feyf2kupc1kbn35fluv5satlmy7fjvmwl9siacg6jq&ep=v1_gifs_random&rid=giphy.mp4&ct=g",
                webp = "https://media1.giphy.com/media/igOgjc5yHX0oLEpL1u/giphy.webp?cid=6df7b0feyf2kupc1kbn35fluv5satlmy7fjvmwl9siacg6jq&ep=v1_gifs_random&rid=giphy.webp&ct=g",
                frames = "4",
                hash = "245473618e35d8d683691d1b7bb063cc",
            ),
        )
        val data = Data(
            id = "2",
            rating = "pg-13",
            slug = "coimma-balpass-megatroncoimma-igOgjc5yHX0oLEpL1u",
            source = null,
            images = images,
            source_post_url = null,
            source_tld = null,
            title = "Gif Title",
            trending_datetime = "",
            type = "gif",
            url = "https://giphy.com/gifs/coimma-balpass-megatroncoimma-igOgjc5yHX0oLEpL1u",
            username = "",
        )
        coEvery { giphyApi.random(API_KEY) } returns RandomGifResponse(data)

        val result = repository.getRandomGif()

        assertEquals(RandomGifResponse(data).mapToRandomGif(), result)

    }

    @Test
    fun `test getting single random Gif from server empty query`(): Unit = runBlocking {
        val data = Data(
            id = null,
            rating = null,
            slug = null,
            source = null,
            images = null,
            source_post_url = null,
            source_tld = null,
            title = null,
            trending_datetime = null,
            type = null,
            url = null,
            username = null,
        )
        coEvery { giphyApi.random(API_KEY) } returns RandomGifResponse(data)

        val result = repository.getRandomGif()

        assertEquals(RandomGifResponse(data).mapToRandomGif(), result)
    }

    @Test
    fun `test search gif with not empty query`() = runBlocking {
        val query = "fr"
        val searchGifs = listOf(
            SearchGif(
                id = "1",
                url = "https://media1.giphy.com/media/igOgjc5yHX0oLEpL1u/giphy.gif?cid=6df7b0feyf2kupc1kbn35fluv5satlmy7fjvmwl9siacg6jq&ep=v1_gifs_random&rid=giphy.gif&ct=g",
                downSizedUrl = "https://media1.giphy.com/media/igOgjc5yHX0oLEpL1u/giphy.gif?cid=6df7b0feyf2kupc1kbn35fluv5satlmy7fjvmwl9siacg6jq&ep=v1_gifs_random&rid=giphy.gif&ct=g",
                title = "Gif Title",
                rating = "pg-10"
            ),
            SearchGif(
                id = "2",
                url = "https://media3.giphy.com/media/u99zrkoXfV4BKxD47r/giphy.gif?cid=6df7b0fe2zhjvlxhkznbwoknmh3f5on4tvupzp2hs9hbib47&ep=v1_gifs_search&rid=giphy.gif&ct=g",
                downSizedUrl = "https://media3.giphy.com/media/u99zrkoXfV4BKxD47r/giphy.gif?cid=6df7b0fe2zhjvlxhkznbwoknmh3f5on4tvupzp2hs9hbib47&ep=v1_gifs_search&rid=giphy.gif&ct=g",
                title = "Gif Title",
                rating = "pg-10"
            )
        )
        val gifPagingResponse = GiphyPagingResponse(
            gifObjects = listOf(

                GifObject(
                    id = "1",
                    images = Images(
                        original = Original(
                            url = "https://media1.giphy.com/media/igOgjc5yHX0oLEpL1u/giphy.gif?cid=6df7b0feyf2kupc1kbn35fluv5satlmy7fjvmwl9siacg6jq&ep=v1_gifs_random&rid=giphy.gif&ct=g",
                        ),
                        downsizedMedium = DownsizedMedium(
                            url = "https://media1.giphy.com/media/igOgjc5yHX0oLEpL1u/giphy.gif?cid=6df7b0feyf2kupc1kbn35fluv5satlmy7fjvmwl9siacg6jq&ep=v1_gifs_random&rid=giphy.gif&ct=g",
                        )
                    ),
                    title = "Gif Title",
                    rating = "pg-10"
                ),
                GifObject(
                    id = "2",
                    images = Images(
                        original = Original(
                            url = "https://media3.giphy.com/media/u99zrkoXfV4BKxD47r/giphy.gif?cid=6df7b0fe2zhjvlxhkznbwoknmh3f5on4tvupzp2hs9hbib47&ep=v1_gifs_search&rid=giphy.gif&ct=g",
                        ),
                        downsizedMedium = DownsizedMedium(
                            url = "https://media3.giphy.com/media/u99zrkoXfV4BKxD47r/giphy.gif?cid=6df7b0fe2zhjvlxhkznbwoknmh3f5on4tvupzp2hs9hbib47&ep=v1_gifs_search&rid=giphy.gif&ct=g",
                        )
                    ),
                    title = "Gif Title",
                    rating = "pg-10"
                )
            )
        )
        coEvery { giphyApi.search(API_KEY, query) } returns gifPagingResponse
        val result = repository.searchGif(query)

        assertEquals(result, searchGifs)
    }
    @Test
    fun `test search gif with empty query`() = runBlocking {
        val query = "fr"
        val searchGifs = listOf<SearchGif>()
        val gifPagingResponse = GiphyPagingResponse(
            gifObjects = listOf()
        )
        coEvery { giphyApi.search(API_KEY, query) } returns gifPagingResponse
        val result = repository.searchGif(query)

        assertEquals(result, searchGifs)
    }
}
