package uz.abdurashidov.newsapp.presentation.detail

import uz.abdurashidov.newsapp.domain.model.Article

sealed class DetailsEvent {
    data class UpsertDeleteArticle(val article: Article):DetailsEvent()

    object RemoveSideEffect:DetailsEvent()
}