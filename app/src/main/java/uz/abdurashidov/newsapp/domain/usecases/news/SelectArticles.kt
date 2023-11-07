package uz.abdurashidov.newsapp.domain.usecases.news

import kotlinx.coroutines.flow.Flow
import uz.abdurashidov.newsapp.data.local.NewsDao
import uz.abdurashidov.newsapp.domain.model.Article

class SelectArticles(
    private val newsDao: NewsDao
) {
    operator fun invoke(): Flow<List<Article>> {
        return newsDao.getArticles()
    }
}