package com.narcis.data.repository

import com.github.davidepanidev.kotlinextensions.deserializeJsonFileFromSystemResources
import com.github.davidepanidev.kotlinextensions.utils.serialization.SerializationManager
import com.github.davidepanidev.kotlinextensions.utils.serialization.gson.GsonSerializationManager
import com.narcis.data.GIF_OBJECT_RANDOM
import com.narcis.data.GIF_OBJECT_SEARCH
import com.narcis.data.api.GiphyApi
import com.narcis.data.mapper.mapToRandomGif
import com.narcis.data.mapper.mapToSearchGif
import com.narcis.data.model.random.RandomGifResponse
import com.narcis.data.model.search.GiphyPagingResponse
import com.narcis.data.model.search.SearchGif
import com.narcis.data.utiles.Constants.API_KEY
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

class GifRepositoryImplTest {

    private lateinit var gifRepositoryImpl: GifRepositoryImpl

    @MockK
    private lateinit var giphyApi: GiphyApi

    private val deserializer: SerializationManager = GsonSerializationManager()
    private val searchApiResponse: GiphyPagingResponse =
        GIF_OBJECT_SEARCH.deserializeJsonFileFromSystemResources(deserializer)
    private val randomApiResponse: RandomGifResponse =
        GIF_OBJECT_RANDOM.deserializeJsonFileFromSystemResources(deserializer)

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        gifRepositoryImpl = GifRepositoryImpl(giphyApi = giphyApi)
    }

    @Test
    fun `retrieveSingleRandomGif notEmptyResponse returnedSuccess`(): Unit = runTest {
        coEvery { giphyApi.random(API_KEY) } returns randomApiResponse

        val result = gifRepositoryImpl.getRandomGif()

        expectThat(randomApiResponse.mapToRandomGif()).isEqualTo(result)
    }

    @Test
    fun `retrieveSearchedGif noneEmptyQuery returnedSuccess`() = runTest {
        val query = "fr"
        coEvery { giphyApi.search(API_KEY, query) } returns searchApiResponse
        val result = gifRepositoryImpl.searchGif(query)
        expectThat(result).isEqualTo(searchApiResponse.gifObjects.map { it.mapToSearchGif() })
    }

    @Test
    fun `retrieveSearchGif emptyQuery returnedSuccess`() = runTest {
        val query = ""
        val searchGifs = listOf<SearchGif>()
        val gifPagingResponse = GiphyPagingResponse(
            gifObjects = listOf(),
        )
        coEvery { giphyApi.search(API_KEY, query) } returns gifPagingResponse
        val result = gifRepositoryImpl.searchGif(query)

        expectThat(result).isEqualTo(searchGifs)
    }
}
