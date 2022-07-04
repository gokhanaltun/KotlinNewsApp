package com.gkhn.kotlinnewsapp.hilt

import com.gkhn.kotlinnewsapp.network.NewsService
import com.gkhn.kotlinnewsapp.repository.INewsRepository
import com.gkhn.kotlinnewsapp.repository.NewsRepository
import com.gkhn.kotlinnewsapp.util.constants.ApiConstants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideNewsService(retrofit: Retrofit): NewsService {
        return retrofit.create(NewsService::class.java)
    }

    @Singleton
    @Provides
    fun provideNewsRepository(newsService: NewsService): INewsRepository{
        return NewsRepository(newsService)
    }
}