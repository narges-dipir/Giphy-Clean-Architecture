package com.narcis.data.mapper

import com.narcis.data.model.random.RandomGif
import com.narcis.data.model.random.RandomGifResponse
import com.narcis.data.model.search.GifObject
import com.narcis.data.model.search.SearchGif

fun GifObject.mapToSearchGif(): SearchGif {
    return SearchGif(
        id = this.id,
        url = this.images?.original?.url,
        downSizedUrl = this.images?.downsizedMedium?.url,
        title = this.title,
        rating = this.rating,
    )
}
fun RandomGifResponse.mapToRandomGif(): RandomGif {
    return RandomGif(
        url = this.randomGifData.images?.original?.url,
        title = this.randomGifData.title ?: "Gif Title",
        id = this.randomGifData.id ?: "",
        rating = this.randomGifData.rating ?: "pg",
    )
}
