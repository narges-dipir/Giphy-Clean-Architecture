package com.narcis.presentation.viewModel

import com.github.davidepanidev.androidextensions.tests.BaseCoroutineTestWithTestDispatcherProviderAndInstantTaskExecutorRule
import com.narcis.domain.common.Result
import com.narcis.domain.model.RandomGifResult
import com.narcis.domain.useCase.RandomGifUseCase
import com.narcis.presentation.mapper.mapToRandomGif
import com.narcis.presentation.viewModel.event.RandomGifEvent
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

@ExperimentalCoroutinesApi
class RandomGifViewModelTest :
    BaseCoroutineTestWithTestDispatcherProviderAndInstantTaskExecutorRule(
        UnconfinedTestDispatcher(),
    ) {

    private var randomGifUseCase: RandomGifUseCase = mockk()

    private lateinit var cut: RandomGifViewModel

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        every {
            randomGifUseCase(Unit)
        } returns flow {
            emit(Result.Loading)
        }
        cut = RandomGifViewModel(
            randomGifUseCase,
        )
    }

    @Test
    fun `get randomGif with success result sets expected gif value`() = runTest {
        val randomGif = RandomGifResult(
            id = "1",
            url = "https://giphy.com/gifs/AgenceLusso-football-soccer-foot-6mm6mUUExaAecMAvMq",
            title = "sample gif_title",
            rating = "pg-15",
        )
        coEvery { randomGifUseCase(Unit) } returns flowOf(Result.Success(randomGif))
        cut.onEvent(RandomGifEvent.AutoTrigger(true))

        expectThat(cut.state.randomGif).isEqualTo(randomGif.mapToRandomGif())
    }


}
