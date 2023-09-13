package com.narcis.data.api

import com.narcis.data.model.random.RandomGifResponse
import com.narcis.data.model.search.GiphyPagingResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface GiphyApi {

    @GET("v1/gifs/random")
    suspend fun random(
        @Query("api_key") apiKey: String,
    ): RandomGifResponse

    @GET("/v1/gifs/search")
    suspend fun search(
        @Query("api_key") apiKey: String,
        @Query("q") query: String,
        @Query("limit") limit: Int = 25,
    ): GiphyPagingResponse
}
