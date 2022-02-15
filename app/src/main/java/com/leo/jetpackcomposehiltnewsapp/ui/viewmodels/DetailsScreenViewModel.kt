package com.leo.jetpackcomposehiltnewsapp.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.leo.jetpackcomposehiltnewsapp.core.utils.MyResult
import com.leo.jetpackcomposehiltnewsapp.domain.News
import com.leo.jetpackcomposehiltnewsapp.usecases.GetNewUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsScreenViewModel @Inject constructor(
    private val getNewUseCase: GetNewUseCase
) : ViewModel() {

    private val _news = MutableLiveData<News>()

    fun getNewsByTitle(title:String): LiveData<News> {
        viewModelScope.launch(Dispatchers.IO) {
            when(val result = getNewUseCase(title)) {
                is MyResult.Success -> {
                    _news.postValue(result.data)
                }
                is MyResult.Failure -> {

                }
            }
        }
        return _news
    }
}