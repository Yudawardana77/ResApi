package com.appslokal.app.data.remote

import com.appslokal.app.data.model.Newslist
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface NewsService {
    @GET ("/")
    fun listNews() : Call<Newslist>

    @GET("detail/")
    fun detailNews(@Query("url")url: String) : Call<Newslist>

    @GET("search/")
    fun searchNews(@Query("q") query: String) : Call<Newslist>
}