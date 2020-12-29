package com.appslokal.app.data.model

data class Newslist (
    val data: List<News> = arrayListOf(),
    val length: Int = 0,
    val status : Int = 0
)