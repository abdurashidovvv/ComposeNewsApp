package uz.abdurashidov.newsapp.domain.usecases.news

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import uz.abdurashidov.newsapp.domain.model.Article
import uz.abdurashidov.newsapp.domain.repository.NewsRepository
import javax.inject.Inject

class SearchNews @Inject constructor(
    private val newsRepository: NewsRepository
) {
    operator fun invoke(searchQuery: String, sources: List<String>): Flow<PagingData<Article>> {
        return newsRepository.searchNews(
            searchQuery = searchQuery,
            source = sources
        )
    }
}