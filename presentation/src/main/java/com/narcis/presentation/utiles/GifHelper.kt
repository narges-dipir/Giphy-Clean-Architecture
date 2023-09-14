package com.narcis.presentation.utiles

import android.content.Context
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.load.resource.gif.GifDrawable
import com.bumptech.glide.request.target.Target
import com.bumptech.glide.signature.ObjectKey

fun loadGif(
    context: Context,
    imageUrl: String,
    thumbnailUrl: String,
    override: Int = Target.SIZE_ORIGINAL,
): RequestBuilder<GifDrawable> {
    val request = Glide.with(context).asGif()
    return request.transition(DrawableTransitionOptions.withCrossFade()).thumbnail(
        request.transition(DrawableTransitionOptions.withCrossFade()).load(thumbnailUrl)
            .override(override).signature(ObjectKey(thumbnailUrl)),
    ).override(override).signature(ObjectKey(imageUrl))
}

fun String.parsPgNumber(): Int? {
    val regex = "\\d+".toRegex()
    val matchResult = regex.find(this)
    return matchResult?.value?.toIntOrNull()
}
