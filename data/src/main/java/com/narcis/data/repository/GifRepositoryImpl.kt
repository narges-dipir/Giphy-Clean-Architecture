package com.narcis.data.repository

import com.narcis.data.api.GiphyApi
import com.narcis.data.mapper.mapToRandomGif
import com.narcis.data.mapper.mapToSearchGif
import com.narcis.data.model.random.RandomGif
import com.narcis.data.model.search.SearchGif
import com.narcis.data.utiles.Constants.API_KEY
import javax.inject.Inject

class GifRepositoryImpl @Inject constructor(
    private val giphyApi: GiphyApi,
) : GifRepository {
    override suspend fun getRandomGif(): RandomGif {
        return giphyApi.random(API_KEY).mapToRandomGif()
    }

    override suspend fun searchGif(query: String): List<SearchGif> {
        return giphyApi.search(API_KEY, query).gifObjects.map { it.mapToSearchGif() }
    }
}
