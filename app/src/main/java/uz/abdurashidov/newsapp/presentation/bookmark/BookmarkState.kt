package uz.abdurashidov.newsapp.presentation.bookmark

import uz.abdurashidov.newsapp.domain.model.Article

data class BookmarkState(
    val articles: List<Article> = emptyList()
)
