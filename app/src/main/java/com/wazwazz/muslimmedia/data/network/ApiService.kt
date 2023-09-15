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
        @Query("apiKey") apiKey: String = "6849a53e1195491495b2b0a17209a630"
    ) : Call<NewsResponse>
}
