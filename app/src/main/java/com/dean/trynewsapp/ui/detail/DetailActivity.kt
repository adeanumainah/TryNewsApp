package com.dean.trynewsapp.ui.detail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import by.kirich1409.viewbindingdelegate.viewBinding
import com.dean.trynewsapp.R
import com.dean.trynewsapp.data.model.ArticleItem
import com.dean.trynewsapp.databinding.ActivityDetailBinding
import com.dean.trynewsapp.utils.loadImage

class DetailActivity : AppCompatActivity() {

    private val binding : ActivityDetailBinding by viewBinding()
    private var newsItem : ArticleItem? = null

    companion object{
        const val DETAIL_EXTRA = "detail"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // ? (nullable)= nullable or can be null
        // !! (bang operator) = cant be null if null DIE
        // ?: (elvish operator)  = if a is null, otherwise b
        newsItem = intent.extras!!.getParcelable(DETAIL_EXTRA)
        newsItem!!.let {
            binding.apply {
                imgDetail.loadImage(it.urlToImage)
                tvNameDetail.text = it.title
                tvDescDetail.text = it.description
            }
        }
    }
}