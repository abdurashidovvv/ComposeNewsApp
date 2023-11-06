package uz.abdurashidov.newsapp.data.remote

import retrofit2.http.GET
import retrofit2.http.Query
import uz.abdurashidov.newsapp.data.remote.dto.NewsResponse
import uz.abdurashidov.newsapp.utils.Constants.API_KEY

interface NewsApi {

    @GET("everything")
    suspend fun getNews(
        @Query("sources") sources: String,
        @Query("page") page: Int,
        @Query("apiKey") apiKey: String = API_KEY
    ): NewsResponse


    @GET("everything")
    suspend fun searchNews(
        @Query("q") searchQuery: String,
        @Query("sources") sources: String,
        @Query("page") page: Int,
        @Query("apiKey") apiKey: String = API_KEY
    ): NewsResponse
}