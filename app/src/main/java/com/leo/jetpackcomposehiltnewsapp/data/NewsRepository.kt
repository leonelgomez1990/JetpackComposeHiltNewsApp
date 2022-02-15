package com.leo.jetpackcomposehiltnewsapp.data

import com.leo.jetpackcomposehiltnewsapp.core.utils.MyResult
import com.leo.jetpackcomposehiltnewsapp.domain.News

interface NewsRepository {
    suspend fun getNews(country: String): MyResult<List<News>>
    suspend fun getNew(title: String): MyResult<News>
}