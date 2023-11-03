package uz.abdurashidov.newsapp.data.remote.dto

import uz.abdurashidov.newsapp.domain.model.Article

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)