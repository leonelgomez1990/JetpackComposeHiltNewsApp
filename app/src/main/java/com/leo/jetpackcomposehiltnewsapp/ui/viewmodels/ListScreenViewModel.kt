package com.leo.jetpackcomposehiltnewsapp.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.leo.jetpackcomposehiltnewsapp.data.NewsRepository
import com.leo.jetpackcomposehiltnewsapp.domain.News
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListScreenViewModel @Inject constructor(
    private val repository: NewsRepository
) : ViewModel() {
    private val _news = MutableLiveData<List<News>>()

    fun getNews(): LiveData<List<News>> {
        viewModelScope.launch(Dispatchers.IO) {
            val news = repository.getNews("US")
            _news.postValue(news)
        }
        return _news
    }
}