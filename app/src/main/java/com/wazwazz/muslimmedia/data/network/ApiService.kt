package com.wazwazz.muslimmedia.data.network


import com.wazwazz.muslimmedia.data.NewsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("everything")
    fun getCommonMuslimNews(
        @Query("q") keyword: String = "islam",
        @Query("language") language: String = "en",
        @Query("sortBy") sortBy: String = "popularity",
        @Query("pageSize") pageSize: Int = 30,
        @Query("apiKey") apiKey: String = "65c5f26a2d5546838231f6986b1e8b5e"
    ): Call<NewsResponse>

    @GET("everything")
    fun getAboutAlquranNews(
        @Query("q") keyword: String = "al quran",
        @Query("language") language: String = "en",
        @Query("sortBy") sortBy: String = "popularity",
        @Query("pageSize") pageSize: Int = 30,
        @Query("apiKey") apiKey: String = "65c5f26a2d5546838231f6986b1e8b5e"
    ): Call<NewsResponse>

    @GET("everything")
    fun getAlJazeeraNews(
        @Query("q") keyword: String = "al jazeera",
        @Query("language") language: String = "en",
        @Query("pageSize") pageSize: Int = 30,
        @Query("apiKey") apiKey: String = "65c5f26a2d5546838231f6986b1e8b5e"
    ): Call<NewsResponse>

    @GET("everything")
    fun getWarmingForIslam(
        @Query("q") keyword: String = "anti islam",
        @Query("apiKey") apiKey: String = "65c5f26a2d5546838231f6986b1e8b5e"
    ): Call<NewsResponse>

    @GET("everything")
    fun searchNews(
        @Query("q") query: String,
        @Query("pageSize") pageSize: Int = 50,
    ): Call<NewsResponse>
}
