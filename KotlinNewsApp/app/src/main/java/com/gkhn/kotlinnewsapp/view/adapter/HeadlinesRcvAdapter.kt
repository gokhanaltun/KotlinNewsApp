package com.gkhn.kotlinnewsapp.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.gkhn.kotlinnewsapp.R
import com.gkhn.kotlinnewsapp.databinding.DesignNewsHeadlinesItemBinding
import com.gkhn.kotlinnewsapp.model.Article
import com.gkhn.kotlinnewsapp.util.callbacks.INewsTitleClickListener
import com.gkhn.kotlinnewsapp.view.fragment.MainFragmentDirections

class HeadlinesRcvAdapter(private val articles: List<Article>): RecyclerView.Adapter<HeadlinesRcvAdapter.ArticleHolder>() {

    class ArticleHolder(val view: DesignNewsHeadlinesItemBinding): RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleHolder {
        val binder = DataBindingUtil.inflate<DesignNewsHeadlinesItemBinding>(
            LayoutInflater.from(parent.context),
            R.layout.design_news_headlines_item,
            parent,
            false
        )
        return ArticleHolder(binder)
    }

    override fun onBindViewHolder(holder: ArticleHolder, position: Int) {
        holder.view.article = articles[position]
        holder.view.clickListener = clickListener
    }

    override fun getItemCount(): Int {
        return articles.size
    }

    private val clickListener = object: INewsTitleClickListener{
        override fun onClickItem(view: View, itemData: Article) {
            val navigation = MainFragmentDirections.toDetailFragment(itemData.url)
            Navigation.findNavController(view).navigate(navigation)
        }
    }
}