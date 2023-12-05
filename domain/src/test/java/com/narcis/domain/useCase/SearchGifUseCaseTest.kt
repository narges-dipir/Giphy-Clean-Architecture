package com.narcis.domain.useCase

import com.narcis.data.model.search.SearchGif
import com.narcis.data.repository.GifRepository
import com.narcis.domain.common.Result
import com.narcis.domain.di.DefaultDispatcherProvider
import com.narcis.domain.mapper.mapToSearchGif
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo
import kotlin.test.assertTrue

class SearchGifUseCaseTest {

    @MockK
    private lateinit var gifRepository: GifRepository

    private lateinit var dispatcherProvider: DefaultDispatcherProvider

    private lateinit var searchGifUseCase: SearchGifUseCase

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        dispatcherProvider = DefaultDispatcherProvider()
        searchGifUseCase = SearchGifUseCase(gifRepository, dispatcherProvider)
    }

    @Test
    fun `invoke searchGif use case with success response emit loading and returns success`() = runTest {
        val query = ""
        val searchGifs = listOf(
            SearchGif(
                id = "1",
                url = "https://giphy.com/gifs/AgenceLusso-football-soccer-foot-6mm6mUUExaAecMAvMq",
                downSizedUrl = "https://media3.giphy.com/media/6mm6mUUExaAecMAvMq/giphy.gif?cid=6df7b0fe2zhjvlxhkznbwoknmh3f5on4tvupzp2hs9hbib47&ep=v1_gifs_search&rid=giphy.gif&ct=g",
                title = "sample gif_title",
                rating = "pg-15",
            ),
        )

        coEvery { gifRepository.searchGif(query = query) } returns searchGifs
        val result = searchGifUseCase(parameters = query).toList()

        assertTrue(result[0] is Result.Loading)
        val successResult = result[1] as Result.Success
        expectThat(successResult.data).isEqualTo(searchGifs.map { it.mapToSearchGif() })
    }

    @Test
    fun `invoke search use case with exception response emit loading then return error on exception`() = runTest {
        val query = ""
        val exception = Exception("Error")
        coEvery { gifRepository.searchGif(query) } throws exception
        val results = searchGifUseCase(query).toList()
        assertTrue(results[0] is Result.Loading)
        val errorResult = results[1] as Result.Error
        expectThat(exception).isEqualTo(errorResult.exception)
    }
}
