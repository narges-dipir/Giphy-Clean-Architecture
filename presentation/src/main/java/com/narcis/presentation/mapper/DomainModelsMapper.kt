package com.narcis.presentation.mapper

import com.narcis.domain.model.RandomGifResult
import com.narcis.domain.model.SearchGifResult
import com.narcis.presentation.model.RandomGif
import com.narcis.presentation.model.SearchGif

fun SearchGifResult.mapToSearchGif(): SearchGif {
    return SearchGif(
        id = this.id,
        url = this.url,
        downSizedUrl = this.downSizedUrl,
        title = this.title,
        rating = this.rating,
    )
}

fun RandomGifResult.mapToRandomGif(): RandomGif {
    return RandomGif(
        url = url,
        title = title,
        id = id,
        rating = rating,
    )
}
