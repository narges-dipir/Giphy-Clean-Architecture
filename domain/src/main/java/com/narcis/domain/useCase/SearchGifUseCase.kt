package com.narcis.domain.useCase

import com.narcis.data.repository.GifRepository
import com.narcis.domain.common.FlowUseCase
import com.narcis.domain.common.Result
import com.narcis.domain.di.DefaultDispatcherProvider
import com.narcis.domain.mapper.mapToSearchGif
import com.narcis.domain.model.SearchGifResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SearchGifUseCase @Inject constructor(
    private val gifRepository: GifRepository,
    dispatcher: DefaultDispatcherProvider,
) : FlowUseCase<String, List<SearchGifResult>>(dispatcher.io) {
    override fun execute(parameters: String): Flow<Result<List<SearchGifResult>>> = flow {

        try {
            emit(Result.Loading)
            val pagingDataOfGifObject = gifRepository.searchGif(parameters)
            emit(Result.Success(pagingDataOfGifObject.map { it.mapToSearchGif() }))

        } catch (e: Exception) {
            emit(Result.Error(e))
        }
    }
}





