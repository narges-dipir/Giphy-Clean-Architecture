package com.narcis.data.repository

import com.narcis.data.model.random.RandomGif
import com.narcis.data.model.search.SearchGif

interface GifRepository {
    suspend fun getRandomGif(): RandomGif
    suspend fun searchGif(query: String): List<SearchGif>
}
