package com.leo.jetpackcomposehiltnewsapp.data

import com.leo.jetpackcomposehiltnewsapp.core.utils.MyResult
import com.leo.jetpackcomposehiltnewsapp.domain.News
import com.leo.jetpackcomposehiltnewsapp.framework.NewsProvider
import javax.inject.Inject

class NewsRepositoryImp @Inject constructor(
    private val newsProvider: NewsProvider
): NewsRepository {

    private var news: List<News> = emptyList()

    override suspend fun getNews(country: String): MyResult<List<News>> {
        return try {
            val apiResponse = newsProvider.topHeadLines(country).body()
            if (apiResponse?.status == "error") {
                when (apiResponse.code) {
                    "apiKeyMissing" -> throw MissingApiKeyException()
                    "apiKeyInvalid" -> throw ApiKeyInvalidException()
                    else -> throw Exception()
                }
            }
            news = apiResponse?.articles ?: emptyList()

            MyResult.Success(news)
        }
        catch (e : Exception) {
            MyResult.Failure(e)
        }

    }

    override suspend fun getNew(title: String): MyResult<News> {
        return try {
            MyResult.Success(news.first { it.title == title })
        }
        catch (e : Exception) {
            MyResult.Failure(e)
        }
    }


}

class MissingApiKeyException : java.lang.Exception()
class ApiKeyInvalidException : java.lang.Exception()