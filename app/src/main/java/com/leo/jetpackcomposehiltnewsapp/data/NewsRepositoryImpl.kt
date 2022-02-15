package com.leo.jetpackcomposehiltnewsapp.data

import com.leo.jetpackcomposehiltnewsapp.domain.News
import com.leo.jetpackcomposehiltnewsapp.framework.NewsProvider
import javax.inject.Inject

class NewsRepositoryImp @Inject constructor(
    private val newsProvider: NewsProvider
): NewsRepository {

    private var news: List<News> = emptyList()

    override suspend fun getNews(country: String): List<News> {
        val apiResponse = newsProvider.topHeadLines(country).body()
        if (apiResponse?.status == "error") {
            when (apiResponse.code) {
                "apiKeyMissing" -> throw MissingApiKeyException()
                "apiKeyInvalid" -> throw ApiKeyInvalidException()
                else -> throw Exception()
            }
        }
        news = apiResponse?.articles ?: emptyList()
        return news
    }

    override fun getNew(title: String): News =
        news.first { it.title == title }

}

class MissingApiKeyException : java.lang.Exception()
class ApiKeyInvalidException : java.lang.Exception()