package uz.abdurashidov.newsapp.domain.usecases.news

import kotlinx.coroutines.flow.Flow
import uz.abdurashidov.newsapp.data.local.NewsDao
import uz.abdurashidov.newsapp.domain.model.Article

class SelectArticles(
    private val newsDao: NewsDao
) {
    suspend operator fun invoke(article: Article): Flow<List<Article>> {
        return newsDao.getArticles()
    }
}