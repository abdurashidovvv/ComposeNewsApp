package uz.abdurashidov.newsapp.domain.usecases.news

import uz.abdurashidov.newsapp.data.local.NewsDao
import uz.abdurashidov.newsapp.domain.model.Article

class UpsertArticle(
    private val newsDao: NewsDao
) {
    suspend operator fun invoke(article: Article) {
        newsDao.upsert(article)
    }
}