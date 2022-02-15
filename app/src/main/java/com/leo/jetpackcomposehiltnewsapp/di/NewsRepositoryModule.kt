package com.leo.jetpackcomposehiltnewsapp.di

import com.leo.jetpackcomposehiltnewsapp.data.NewsRepository
import com.leo.jetpackcomposehiltnewsapp.data.NewsRepositoryImp
import com.leo.jetpackcomposehiltnewsapp.framework.NewsProvider
import com.leo.jetpackcomposehiltnewsapp.usecases.GetNewUseCase
import com.leo.jetpackcomposehiltnewsapp.usecases.GetNewsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NewsRepositoryModule {

    @Provides
    @Singleton
    fun providerNewsRepository(provider: NewsProvider): NewsRepository = NewsRepositoryImp(provider)

    @Provides
    fun provideGetNewUseCase(newsRepository: NewsRepository): GetNewUseCase = GetNewUseCase(newsRepository)

    @Provides
    fun provideGetNewsUseCase(newsRepository: NewsRepository): GetNewsUseCase = GetNewsUseCase(newsRepository)
}