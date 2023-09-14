package com.narcis.domain.useCase

import com.narcis.data.api.GiphyApi
import com.narcis.data.model.search.SearchGif
import com.narcis.data.repository.GifRepository
import com.narcis.data.repository.GifRepositoryImpl
import com.narcis.domain.common.Result
import com.narcis.domain.di.DefaultDispatcherProvider
import com.narcis.domain.model.SearchGifResult
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import timber.log.Timber
import kotlin.test.assertEquals

class SearchGifUseCaseTest {
    @MockK
    private lateinit var giphyApi: GiphyApi

    @MockK
    private lateinit var gifRepository: GifRepository

    private lateinit var dispatcherProvider: DefaultDispatcherProvider

    private lateinit var searchGifUseCase: SearchGifUseCase

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        dispatcherProvider = DefaultDispatcherProvider()
        gifRepository = GifRepositoryImpl(giphyApi = giphyApi)
        searchGifUseCase = SearchGifUseCase(gifRepository, dispatcherProvider)
    }

    @Test
    fun `test executing search gif useCase retuning a result of searched gifs`() = runBlocking {
        val searchGifResults = listOf(
            SearchGifResult(
                id = "1",
                url = "https://giphy.com/gifs/AgenceLusso-football-soccer-foot-6mm6mUUExaAecMAvMq",
                downSizedUrl = "https://media3.giphy.com/media/6mm6mUUExaAecMAvMq/giphy.gif?cid=6df7b0fe2zhjvlxhkznbwoknmh3f5on4tvupzp2hs9hbib47&ep=v1_gifs_search&rid=giphy.gif&ct=g",
                title = "sample gif_title",
                rating = "pg-15"
            )
        )
        val expectedRandomGifResult = Result.Success(searchGifResults)

        val searchGifs = listOf(
            SearchGif(
                id = "1",
                url = "https://giphy.com/gifs/AgenceLusso-football-soccer-foot-6mm6mUUExaAecMAvMq",
                downSizedUrl = "https://media3.giphy.com/media/6mm6mUUExaAecMAvMq/giphy.gif?cid=6df7b0fe2zhjvlxhkznbwoknmh3f5on4tvupzp2hs9hbib47&ep=v1_gifs_search&rid=giphy.gif&ct=g",
                title = "sample gif_title",
                rating = "pg-15"
            )
        )
        val query = "fr"

        coEvery { gifRepository.searchGif(query = query) } returns searchGifs
        val result = searchGifUseCase(parameters = query)
        result.collect { rstl ->
            when (rstl) {
                is Result.Error -> {
                    Timber.e("Test Error", rstl.exception.toString())
                }

                Result.Loading -> {
                    assertEquals(Result.Loading, rstl)
                }

                is Result.Success -> {
                    assertEquals(expectedRandomGifResult.data, rstl.data)
                }
            }

        }
    }
}