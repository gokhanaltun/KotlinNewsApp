package com.gkhn.kotlinnewsapp.util.extensions

import android.widget.ImageView
import com.gkhn.kotlinnewsapp.R
import com.squareup.picasso.Picasso

fun ImageView.loadImageFromUrl(url: String?){
    Picasso.get()
        .load(url)
        .placeholder(R.drawable.placeholder)
        .error(R.drawable.image_error)
        .into(this)
}
