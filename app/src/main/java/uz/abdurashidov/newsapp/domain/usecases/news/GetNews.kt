package uz.abdurashidov.newsapp.domain.usecases.news

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import uz.abdurashidov.newsapp.domain.model.Article
import uz.abdurashidov.newsapp.domain.repository.NewsRepository
import javax.inject.Inject

class GetNews @Inject constructor(
    private val newsRepository: NewsRepository
) {
    operator fun invoke(sources: List<String>): Flow<PagingData<Article>> {
        return newsRepository.getNews(source = sources)
    }
}
