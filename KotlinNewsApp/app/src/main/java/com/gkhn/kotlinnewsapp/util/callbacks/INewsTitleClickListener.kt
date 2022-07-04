package com.gkhn.kotlinnewsapp.util.callbacks

import android.view.View
import com.gkhn.kotlinnewsapp.model.Article

interface INewsTitleClickListener {

    fun onClickItem(view: View, itemData: Article)
}