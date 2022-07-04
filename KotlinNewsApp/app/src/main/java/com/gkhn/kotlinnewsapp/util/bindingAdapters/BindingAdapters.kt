package com.gkhn.kotlinnewsapp.util.bindingAdapters

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.gkhn.kotlinnewsapp.util.extensions.loadImageFromUrl


@BindingAdapter("android:urlSrc")
fun urlSrc(view: ImageView, url: String?){
    view.loadImageFromUrl(url)
}