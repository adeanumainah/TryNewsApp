package com.dean.trynewsapp.data.source

import com.dean.trynewsapp.data.model.ResponseNews
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("top-headlines")
    suspend fun fetchNews(

        @Query("country") country : String,
        @Query("category") category: String,
        @Query("sources") apiKey : String,
    ): ResponseNews
}