package com.narcis.data.model.search

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

data class GiphyPagingResponse(
    @SerializedName("data")
    val gifObjects: List<GifObject>,
)

data class GifObject(
    @SerializedName("analytics_response_payload")
    val analyticsResponsePayload: String? = null,
    @SerializedName("bitly_gif_url")
    val bitlyGifUrl: String? = null,
    @SerializedName("bitly_url")
    val bitlyUrl: String? = null,
    @SerializedName("content_url")
    val contentUrl: String? = null,
    @SerializedName("embed_url")
    val embedUrl: String? = null,
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("images")
    val images: Images? = null,
    @SerializedName("import_datetime")
    val importDatetime: String? = null,
    @SerializedName("is_sticker")
    val isSticker: Int? = null,
    @SerializedName("rating")
    val rating: String? = null,
    @SerializedName("slug")
    val slug: String? = null,
    @SerializedName("source")
    val source: String? = null,
    @SerializedName("source_post_url")
    val sourcePostUrl: String? = null,
    @SerializedName("source_tld")
    val sourceTld: String? = null,
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("trending_datetime")
    val trendingDatetime: String? = null,
    @SerializedName("type")
    val type: String? = null,
    @SerializedName("url")
    val url: String? = null,
    @SerializedName("user")
    val user: User? = null,
    @SerializedName("username")
    val username: String? = null,
)

@Serializable
data class Images(
    @SerializedName("downsized")
    val downsized: Downsized? = null,
    @SerializedName("downsized_large")
    val downsizedLarge: DownsizedLarge? = null,
    @SerializedName("downsized_medium")
    val downsizedMedium: DownsizedMedium? = null,
    @SerializedName("downsized_small")
    val downsizedSmall: DownsizedSmall? = null,
    @SerializedName("downsized_still")
    val downsizedStill: DownsizedStill? = null,
    @SerializedName("fixed_height")
    val fixedHeight: FixedHeight? = null,
    @SerializedName("fixed_height_downsampled")
    val fixedHeightDownsampled: FixedHeightDownsampled? = null,
    @SerializedName("fixed_height_small")
    val fixedHeightSmall: FixedHeightSmall? = null,
    @SerializedName("fixed_height_small_still")
    val fixedHeightSmallStill: FixedHeightSmallStill? = null,
    @SerializedName("fixed_height_still")
    val fixedHeightStill: FixedHeightStill? = null,
    @SerializedName("fixed_width")
    val fixedWidth: FixedWidth? = null,
    @SerializedName("fixed_width_downsampled")
    val fixedWidthDownsampled: FixedWidthDownsampled? = null,
    @SerializedName("fixed_width_small")
    val fixedWidthSmall: FixedWidthSmall? = null,
    @SerializedName("fixed_width_small_still")
    val fixedWidthSmallStill: FixedWidthSmallStill? = null,
    @SerializedName("fixed_width_still")
    val fixedWidthStill: FixedWidthStill? = null,
    @SerializedName("hd")
    val hd: Hd? = null,
    @SerializedName("looping")
    val looping: Looping? = null,
    @SerializedName("original")
    val original: Original? = null,
    @SerializedName("original_mp4")
    val originalMp4: OriginalMp4? = null,
    @SerializedName("original_still")
    val originalStill: OriginalStill? = null,
    @SerializedName("preview")
    val preview: Preview? = null,
    @SerializedName("preview_gif")
    val previewGif: PreviewGif? = null,
    @SerializedName("preview_webp")
    val previewWebp: PreviewWebp? = null,
    @SerializedName("480w_still")
    val wStill: WStill? = null,
)

@Serializable
data class Downsized(
    @SerializedName("height")
    val height: String? = null,
    @SerializedName("size")
    val size: String? = null,
    @SerializedName("url")
    val url: String? = null,
    @SerializedName("width")
    val width: String? = null,
)

@Serializable
data class DownsizedLarge(
    @SerializedName("height")
    val height: String? = null,
    @SerializedName("size")
    val size: String? = null,
    @SerializedName("url")
    val url: String? = null,
    @SerializedName("width")
    val width: String? = null,
)

@Serializable
data class DownsizedMedium(
    @SerializedName("height")
    val height: String? = null,
    @SerializedName("size")
    val size: String? = null,
    @SerializedName("url")
    val url: String? = null,
    @SerializedName("width")
    val width: String? = null,
)

@Serializable
data class DownsizedSmall(
    @SerializedName("height")
    val height: String? = null,
    @SerializedName("mp4")
    val mp4: String? = null,
    @SerializedName("mp4_size")
    val mp4Size: String? = null,
    @SerializedName("width")
    val width: String? = null,
)

@Serializable
data class DownsizedStill(
    @SerializedName("height")
    val height: String? = null,
    @SerializedName("size")
    val size: String? = null,
    @SerializedName("url")
    val url: String? = null,
    @SerializedName("width")
    val width: String? = null,
)

@Serializable
data class FixedHeight(
    @SerializedName("height")
    val height: String? = null,
    @SerializedName("mp4")
    val mp4: String? = null,
    @SerializedName("mp4_size")
    val mp4Size: String? = null,
    @SerializedName("size")
    val size: String? = null,
    @SerializedName("url")
    val url: String? = null,
    @SerializedName("webp")
    val webp: String? = null,
    @SerializedName("webp_size")
    val webpSize: String? = null,
    @SerializedName("width")
    val width: String? = null,
)

@Serializable
data class FixedHeightDownsampled(
    @SerializedName("height")
    val height: String? = null,
    @SerializedName("size")
    val size: String? = null,
    @SerializedName("url")
    val url: String? = null,
    @SerializedName("webp")
    val webp: String? = null,
    @SerializedName("webp_size")
    val webpSize: String? = null,
    @SerializedName("width")
    val width: String? = null,
)

@Serializable
data class FixedHeightSmall(
    @SerializedName("height")
    val height: String? = null,
    @SerializedName("mp4")
    val mp4: String? = null,
    @SerializedName("mp4_size")
    val mp4Size: String? = null,
    @SerializedName("size")
    val size: String? = null,
    @SerializedName("url")
    val url: String? = null,
    @SerializedName("webp")
    val webp: String? = null,
    @SerializedName("webp_size")
    val webpSize: String? = null,
    @SerializedName("width")
    val width: String? = null,
)

@Serializable
data class FixedHeightSmallStill(
    @SerializedName("height")
    val height: String? = null,
    @SerializedName("size")
    val size: String? = null,
    @SerializedName("url")
    val url: String? = null,
    @SerializedName("width")
    val width: String? = null,
)

@Serializable
data class FixedHeightStill(
    @SerializedName("height")
    val height: String? = null,
    @SerializedName("size")
    val size: String? = null,
    @SerializedName("url")
    val url: String? = null,
    @SerializedName("width")
    val width: String? = null,
)

@Serializable
data class FixedWidth(
    @SerializedName("height")
    val height: String? = null,
    @SerializedName("mp4")
    val mp4: String? = null,
    @SerializedName("mp4_size")
    val mp4Size: String? = null,
    @SerializedName("size")
    val size: String? = null,
    @SerializedName("url")
    val url: String? = null,
    @SerializedName("webp")
    val webp: String? = null,
    @SerializedName("webp_size")
    val webpSize: String? = null,
    @SerializedName("width")
    val width: String? = null,
)

@Serializable
data class FixedWidthDownsampled(
    @SerializedName("height")
    val height: String? = null,
    @SerializedName("size")
    val size: String? = null,
    @SerializedName("url")
    val url: String? = null,
    @SerializedName("webp")
    val webp: String? = null,
    @SerializedName("webp_size")
    val webpSize: String? = null,
    @SerializedName("width")
    val width: String? = null,
)

@Serializable
data class FixedWidthSmall(
    @SerializedName("height")
    val height: String? = null,
    @SerializedName("mp4")
    val mp4: String? = null,
    @SerializedName("mp4_size")
    val mp4Size: String? = null,
    @SerializedName("size")
    val size: String? = null,
    @SerializedName("url")
    val url: String? = null,
    @SerializedName("webp")
    val webp: String? = null,
    @SerializedName("webp_size")
    val webpSize: String? = null,
    @SerializedName("width")
    val width: String? = null,
)

@Serializable
data class FixedWidthSmallStill(
    @SerializedName("height")
    val height: String? = null,
    @SerializedName("size")
    val size: String? = null,
    @SerializedName("url")
    val url: String? = null,
    @SerializedName("width")
    val width: String? = null,
)

@Serializable
data class FixedWidthStill(
    @SerializedName("height")
    val height: String? = null,
    @SerializedName("size")
    val size: String? = null,
    @SerializedName("url")
    val url: String? = null,
    @SerializedName("width")
    val width: String? = null,
)

@Serializable
data class Hd(
    @SerializedName("height")
    val height: String? = null,
    @SerializedName("mp4")
    val mp4: String? = null,
    @SerializedName("mp4_size")
    val mp4Size: String? = null,
    @SerializedName("width")
    val width: String? = null,
)

@Serializable
data class Looping(
    @SerializedName("mp4")
    val mp4: String? = null,
    @SerializedName("mp4_size")
    val mp4Size: String? = null,
)

@Serializable
data class Original(
    @SerializedName("frames")
    val frames: String? = null,
    @SerializedName("hash")
    val hash: String? = null,
    @SerializedName("height")
    val height: String? = null,
    @SerializedName("mp4")
    val mp4: String? = null,
    @SerializedName("mp4_size")
    val mp4Size: String? = null,
    @SerializedName("size")
    val size: String? = null,
    @SerializedName("url")
    val url: String? = null,
    @SerializedName("webp")
    val webp: String? = null,
    @SerializedName("webp_size")
    val webpSize: String? = null,
    @SerializedName("width")
    val width: String? = null,
)

@Serializable
data class OriginalMp4(
    @SerializedName("height")
    val height: String? = null,
    @SerializedName("mp4")
    val mp4: String? = null,
    @SerializedName("mp4_size")
    val mp4Size: String? = null,
    @SerializedName("width")
    val width: String? = null,
)

@Serializable
data class OriginalStill(
    @SerializedName("height")
    val height: String? = null,
    @SerializedName("size")
    val size: String? = null,
    @SerializedName("url")
    val url: String? = null,
    @SerializedName("width")
    val width: String? = null,
)

@Serializable
data class Preview(
    @SerializedName("height")
    val height: String? = null,
    @SerializedName("mp4")
    val mp4: String? = null,
    @SerializedName("mp4_size")
    val mp4Size: String? = null,
    @SerializedName("width")
    val width: String? = null,
)

@Serializable
data class PreviewGif(
    @SerializedName("height")
    val height: String? = null,
    @SerializedName("size")
    val size: String? = null,
    @SerializedName("url")
    val url: String? = null,
    @SerializedName("width")
    val width: String? = null,
)

@Serializable
data class PreviewWebp(
    @SerializedName("height")
    val height: String? = null,
    @SerializedName("size")
    val size: String? = null,
    @SerializedName("url")
    val url: String? = null,
    @SerializedName("width")
    val width: String? = null,
)

@Serializable
data class WStill(
    @SerializedName("height")
    val height: String? = null,
    @SerializedName("size")
    val size: String? = null,
    @SerializedName("url")
    val url: String? = null,
    @SerializedName("width")
    val width: String? = null,
)

@Serializable
data class User(
    @SerializedName("avatar_url")
    val avatarUrl: String? = null,
    @SerializedName("banner_image")
    val bannerImage: String? = null,
    @SerializedName("banner_url")
    val bannerUrl: String? = null,
    @SerializedName("description")
    val description: String? = null,
    @SerializedName("display_name")
    val displayName: String? = null,
    @SerializedName("instagram_url")
    val instagramUrl: String? = null,
    @SerializedName("is_verified")
    val isVerified: Boolean? = null,
    @SerializedName("profile_url")
    val profileUrl: String? = null,
    @SerializedName("username")
    val username: String? = null,
    @SerializedName("website_url")
    val websiteUrl: String? = null,
)
