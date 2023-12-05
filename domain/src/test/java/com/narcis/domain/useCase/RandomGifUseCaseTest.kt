package com.narcis.domain.useCase

import com.narcis.data.model.random.RandomGif
import com.narcis.data.repository.GifRepository
import com.narcis.domain.common.Result
import com.narcis.domain.di.DefaultDispatcherProvider
import com.narcis.domain.mapper.mapToRandomGifResult
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class RandomGifUseCaseTest {

    @MockK
    private lateinit var gifRepository: GifRepository

    private lateinit var dispatcherProvider: DefaultDispatcherProvider

    private lateinit var randomGifUseCase: RandomGifUseCase

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        dispatcherProvider = DefaultDispatcherProvider()
        randomGifUseCase = RandomGifUseCase(gifRepository, dispatcherProvider)
    }

    @Test
    fun `invoke with Success Response Returns Success`(): Unit = runTest {
        val expectedRandomGif = RandomGif(
            id = "1",
            url = "https://giphy.com/gifs/AgenceLusso-football-soccer-foot-6mm6mUUExaAecMAvMq",
            title = "sample gif_title",
            rating = "pg-15",
        )

        coEvery { gifRepository.getRandomGif() } returns expectedRandomGif

        val actualResult = randomGifUseCase(Unit)
    }

    @Test
    fun `random gif use case emits loading and then success`() = runTest {
        val randomGif = RandomGif(
            id = "1",
            url = "https://giphy.com/gifs/AgenceLusso-football-soccer-foot-6mm6mUUExaAecMAvMq",
            title = "sample gif_title",
            rating = "pg-15",
        )
        coEvery { gifRepository.getRandomGif() } returns randomGif

        val results = randomGifUseCase(Unit).toList()

        assertTrue(results[0] is Result.Loading)

        val successResult = results[1] as Result.Success
        expectThat(successResult.data).isEqualTo(randomGif.mapToRandomGifResult())
    }

    @Test
    fun `random gif use case emits loading and then error on exception`() = runTest {
        val exception = RuntimeException("Error")
        coEvery { gifRepository.getRandomGif() } throws exception
        val results = randomGifUseCase(Unit).toList()
        assertTrue(results[0] is Result.Loading)
        val errorResult = results[1] as Result.Error
        assertEquals(exception, errorResult.exception)
    }
}
