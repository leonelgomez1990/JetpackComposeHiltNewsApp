package com.leo.jetpackcomposehiltnewsapp.framework

import com.leo.jetpackcomposehiltnewsapp.domain.News

interface NewsRepository {
    suspend fun getNews(country: String): List<News>
    fun getNew(title: String): News
}