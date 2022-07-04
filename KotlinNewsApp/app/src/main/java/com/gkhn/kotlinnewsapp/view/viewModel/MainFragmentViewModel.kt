package com.gkhn.kotlinnewsapp.view.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gkhn.kotlinnewsapp.model.DataStatus
import com.gkhn.kotlinnewsapp.model.NewsResponse
import com.gkhn.kotlinnewsapp.repository.INewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainFragmentViewModel @Inject constructor(private val newsRepository: INewsRepository): ViewModel() {

    val topHeadlines = MutableLiveData<DataStatus<NewsResponse>>()
    val topScienceHeadlines = MutableLiveData<DataStatus<NewsResponse>>()
    val topSportsHeadlines = MutableLiveData<DataStatus<NewsResponse>>()

    fun getTopHeadlines() {
        viewModelScope.launch {
            val data = newsRepository.getTopHeadlines()
            topHeadlines.postValue(data)
        }
    }

    fun getTopScienceHeadlines() {
        viewModelScope.launch {
            val data = newsRepository.getTopScienceHeadlines()
            topScienceHeadlines.postValue(data)
        }
    }

    fun getTopSportsHeadlines() {
        viewModelScope.launch {
            val data = newsRepository.getTopSportsHeadlines()
            topSportsHeadlines.postValue(data)
        }
    }

}