package com.narcis.domain.mapper

import com.narcis.data.model.random.RandomGif
import com.narcis.data.model.search.SearchGif
import com.narcis.domain.model.RandomGifResult
import com.narcis.domain.model.SearchGifResult


fun SearchGif.mapToSearchGif(): SearchGifResult {
    return SearchGifResult(
        id = this.id,
        url = this.url,
        downSizedUrl = downSizedUrl,
        title = this.title,
        rating = this.rating
    )
}

fun RandomGif.mapToRandomGifResult(): RandomGifResult {
    return RandomGifResult(
        url,
        title,
        id,
        rating
    )
}