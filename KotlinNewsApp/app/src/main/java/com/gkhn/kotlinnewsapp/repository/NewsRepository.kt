package com.gkhn.kotlinnewsapp.repository

import com.gkhn.kotlinnewsapp.model.DataStatus
import com.gkhn.kotlinnewsapp.model.NewsResponse
import com.gkhn.kotlinnewsapp.network.NewsService
import javax.inject.Inject

class NewsRepository @Inject constructor(private val newsService: NewsService): INewsRepository {
    override suspend fun getTopHeadlines(): DataStatus<NewsResponse> {
        val data = newsService.getTopHeadlines()
        return if (data.isSuccessful) DataStatus.success(data.body()) else DataStatus.error("headline Error")
    }

    override suspend fun getTopScienceHeadlines(): DataStatus<NewsResponse> {
        val data = newsService.getTopHeadlinesByCategory(category = "science", pageSize = 5)
        return if (data.isSuccessful) DataStatus.success(data.body()) else DataStatus.error("science Error")
    }

    override suspend fun getTopSportsHeadlines(): DataStatus<NewsResponse> {
        val data = newsService.getTopHeadlinesByCategory(category = "sports", pageSize = 5)
        return if (data.isSuccessful) DataStatus.success(data.body()) else DataStatus.error("sports Error")
    }

}