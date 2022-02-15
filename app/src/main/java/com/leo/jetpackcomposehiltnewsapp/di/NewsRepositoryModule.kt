package com.leo.jetpackcomposehiltnewsapp.di

import com.leo.jetpackcomposehiltnewsapp.data.NewsRepository
import com.leo.jetpackcomposehiltnewsapp.data.NewsRepositoryImp
import com.leo.jetpackcomposehiltnewsapp.framework.NewsProvider
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
    fun providerNewsRepository(provider: NewsProvider): NewsRepository =
        NewsRepositoryImp(provider)
}