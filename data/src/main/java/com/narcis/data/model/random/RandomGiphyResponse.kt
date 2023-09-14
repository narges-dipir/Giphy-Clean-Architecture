package com.narcis.data.model.random

import com.google.gson.annotations.SerializedName
import com.narcis.data.model.search.Images
import com.narcis.data.model.search.User

data class RandomGifResponse(
    @SerializedName("data")
    val randomGifData: Data,
)
data class Data(
    @SerializedName("id")
    val id: String?,
    @SerializedName("rating")
    val rating: String? = "pg-?",
    @SerializedName("slug")
    val slug: String?,
    @SerializedName("source")
    val source: String?,
    @SerializedName("source_post_url")
    val source_post_url: String?,
    @SerializedName("source_tld")
    val source_tld: String?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("trending_datetime")
    val trending_datetime: String?,
    @SerializedName("type")
    val type: String?,
    @SerializedName("url")
    val url: String?,
    @SerializedName("user")
    val user: User ? = null,
    @SerializedName("username")
    val username: String?,
    @SerializedName("images")
    val images: Images? = null,
)

