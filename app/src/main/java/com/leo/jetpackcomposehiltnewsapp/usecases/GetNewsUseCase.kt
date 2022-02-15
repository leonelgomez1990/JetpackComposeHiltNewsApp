package com.leo.jetpackcomposehiltnewsapp.usecases

import com.leo.jetpackcomposehiltnewsapp.core.utils.MyResult
import com.leo.jetpackcomposehiltnewsapp.data.NewsRepository
import com.leo.jetpackcomposehiltnewsapp.domain.News

class GetNewsUseCase (val newsRepository: NewsRepository) {
    suspend operator fun invoke(news : String) : MyResult< List<News>> = newsRepository.getNews(news)
}