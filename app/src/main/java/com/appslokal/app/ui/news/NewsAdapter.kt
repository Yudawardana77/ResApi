package com.appslokal.app.ui.news

import android.content.Context
import android.content.Intent
import androidx.databinding.ViewDataBinding
import com.appslokal.app.R
import com.appslokal.app.data.model.News
import com.appslokal.app.databinding.ItemNewsBinding
import com.appslokal.app.ui.base.BaseAdapter
import com.bumptech.glide.Glide

class NewsAdapter(val context: Context) : BaseAdapter<News>(R.layout.item_news) {
    override fun onBind(binding: ViewDataBinding?, data: News) {
        val mBinding = binding as ItemNewsBinding
        Glide.with(context).load(data.poster).into(mBinding.itemposter)
    }

    override fun onClick(binding: ViewDataBinding?, data: News) {
        val intent = Intent(context, NewsActivity::class.java)
        intent.putExtra(NewsActivity.OPEN_NEWS, data)
        context.startActivity(intent)
    }
}