package uz.abdurashidov.newsapp.presentation.search

sealed class SearchEvent {

    data class UpdatesSearchQuery(val searchQuery: String) : SearchEvent()

    object SearchNews : SearchEvent()
}
