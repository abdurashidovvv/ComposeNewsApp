package uz.abdurashidov.newsapp.data.remote

import retrofit2.http.GET
import retrofit2.http.Query
import uz.abdurashidov.newsapp.data.remote.dto.NewsResponse
import uz.abdurashidov.newsapp.utils.Constants.API_KEY

interface NewsApi {

    @GET("everything")
    fun getNews(
        @Query("page") page: Int,
        @Query("source") source: String,
        @Query("apiKey") apiKey: String = API_KEY
    ): NewsResponse
}