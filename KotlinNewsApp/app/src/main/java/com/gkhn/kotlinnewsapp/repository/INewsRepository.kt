package com.gkhn.kotlinnewsapp.repository

import com.gkhn.kotlinnewsapp.model.DataStatus
import com.gkhn.kotlinnewsapp.model.NewsResponse

interface INewsRepository {

    suspend fun getTopHeadlines(): DataStatus<NewsResponse>
    suspend fun getTopScienceHeadlines(): DataStatus<NewsResponse>
    suspend fun getTopSportsHeadlines(): DataStatus<NewsResponse>

}