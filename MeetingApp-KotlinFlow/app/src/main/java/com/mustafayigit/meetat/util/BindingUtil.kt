package com.mustafayigit.meetat.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

/**
 * Created By MUSTAFA
 * on 22/05/2020
 */

@BindingAdapter("loadImage")
fun loadImage(imageView: ImageView, url: String) {
    Glide.with(imageView.context)
        .load(url)
        .centerCrop()
        .into(imageView)
}