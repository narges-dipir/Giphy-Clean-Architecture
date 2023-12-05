package com.narcis.domain.useCase

import com.narcis.data.repository.GifRepository
import com.narcis.domain.common.FlowUseCase
import com.narcis.domain.common.Result
import com.narcis.domain.di.DefaultDispatcherProvider
import com.narcis.domain.mapper.mapToRandomGifResult
import com.narcis.domain.model.RandomGifResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RandomGifUseCase @Inject constructor(
    private val gifRepository: GifRepository,
    dispatcher: DefaultDispatcherProvider,
) : FlowUseCase<Unit, RandomGifResult>(dispatcher.io) {
    override fun execute(parameters: Unit): Flow<Result<RandomGifResult>> = flow {
        try {
            emit(Result.Loading)
            val result = gifRepository.getRandomGif().mapToRandomGifResult()
            emit(Result.Success(result))
        } catch (e: Exception) {
            emit(Result.Error(e))
        }
    }
}
