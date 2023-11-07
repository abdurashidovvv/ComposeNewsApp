package uz.abdurashidov.newsapp.domain.usecases.news

import uz.abdurashidov.newsapp.data.local.NewsDao
import uz.abdurashidov.newsapp.domain.model.Article

class SelectArticle(
    private val newsDao: NewsDao
) {
    suspend operator fun invoke(article: String): Article? {
        return newsDao.getArticle(article)
    }
}