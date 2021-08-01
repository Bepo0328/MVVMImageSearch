package kr.co.bepo.mvvmimagesearch.util

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory
import kr.co.bepo.mvvmimagesearch.R

private val factory = DrawableCrossFadeFactory.Builder().setCrossFadeEnabled(true).build()

private fun ImageView.clear() = Glide.with(context).clear(this)

internal fun ImageView.load(url: String) {
    Glide.with(this)
        .load(url)
        .centerCrop()
        .transition(DrawableTransitionOptions.withCrossFade(factory))
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .error(R.drawable.ic_error)
        .into(this)
}
