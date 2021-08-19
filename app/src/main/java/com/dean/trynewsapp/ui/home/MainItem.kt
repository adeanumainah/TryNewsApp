package com.dean.trynewsapp.ui.home

import android.view.View
import com.dean.trynewsapp.R
import com.dean.trynewsapp.data.model.ArticleItem
import com.dean.trynewsapp.databinding.NewsItemViewBinding
import com.dean.trynewsapp.utils.loadImage
import com.xwray.groupie.viewbinding.BindableItem

class MainItem (
    private val article: ArticleItem,
    private val onClick: (ArticleItem) -> Unit
) : BindableItem<NewsItemViewBinding>(){
    override fun bind(viewBinding: NewsItemViewBinding, position: Int) {
        //ngambil data dari news
        viewBinding.apply {
            tvItemName.text = article.title
            imgItem.loadImage(article.urlToImage)
            tvItemDesc.text = article.description

            itemCard.setOnClickListener {
                onClick(article)
            }
        }
    }

    override fun getLayout(): Int = R.layout.news_item_view

    override fun initializeViewBinding(view: View): NewsItemViewBinding {
        return NewsItemViewBinding.bind(view)
    }
}