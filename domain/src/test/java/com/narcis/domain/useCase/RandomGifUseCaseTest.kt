package com.narcis.domain.useCase

import com.narcis.data.api.GiphyApi
import com.narcis.data.model.random.RandomGif
import com.narcis.data.repository.GifRepository
import com.narcis.data.repository.GifRepositoryImpl
import com.narcis.domain.common.Result
import com.narcis.domain.di.DefaultDispatcherProvider
import com.narcis.domain.model.RandomGifResult
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import timber.log.Timber
import kotlin.test.assertEquals

class RandomGifUseCaseTest {

    @MockK
    private lateinit var giphyApi: GiphyApi

    @MockK
    private lateinit var gifRepository: GifRepository

    private lateinit var dispatcherProvider: DefaultDispatcherProvider

    private lateinit var randomGifUseCase: RandomGifUseCase

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        dispatcherProvider = DefaultDispatcherProvider()
        gifRepository = GifRepositoryImpl(giphyApi = giphyApi)
        randomGifUseCase = RandomGifUseCase(gifRepository, dispatcherProvider)
    }

    @Test
    fun `test executing RandomGifUseCase returns a RandomGifResult`(): Unit = runBlocking {
        val mockRandomGif = RandomGif(
            id = "1",
            url = "https://giphy.com/gifs/AgenceLusso-football-soccer-foot-6mm6mUUExaAecMAvMq",
            title = "sample gif_title",
            rating = "pg-15"
        )
        val expectedRandomGifResult = Result.Success(
            RandomGifResult(
                id = "1",
                url = "https://giphy.com/gifs/AgenceLusso-football-soccer-foot-6mm6mUUExaAecMAvMq",
                title = "sample gif_title",
                rating = "pg-15"
            )
        )
        val expectedResult = expectedRandomGifResult.data
        coEvery { gifRepository.getRandomGif() } returns mockRandomGif

        val result = randomGifUseCase(Unit)

        result.collect { rst ->
            when (rst) {
                is Result.Error -> {
                    Timber.e("Test Error", rst.exception.toString())
                }

                Result.Loading -> {
                    assertEquals(Result.Loading, rst)
                }

                is Result.Success -> {
                    assertEquals(rst.data, expectedResult)
                }
            }
        }

    }
}