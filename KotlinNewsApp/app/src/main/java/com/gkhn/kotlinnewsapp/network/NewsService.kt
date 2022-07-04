package com.gkhn.kotlinnewsapp.network

import com.gkhn.kotlinnewsapp.model.NewsResponse
import com.gkhn.kotlinnewsapp.util.constants.ApiConstants.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {
    @GET("top-headlines")
    suspend fun getTopHeadlines(
        @Query("country") country: String = "tr",
        @Query("pageSize") pageSize: Int = 5,
        @Query("apiKey") apiKey: String = API_KEY,
        ): Response<NewsResponse>

    @GET("top-headlines")
    suspend fun getTopHeadlinesByCategory(
        @Query("category") category: String,
        @Query("country") country: String = "tr",
        @Query("pageSize") pageSize: Int = 20,
        @Query("apiKey") apiKey: String = API_KEY,
    ): Response<NewsResponse>
}