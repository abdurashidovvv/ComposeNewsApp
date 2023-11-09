package uz.abdurashidov.newsapp.domain.usecases.news

import kotlinx.coroutines.flow.Flow
import uz.abdurashidov.newsapp.data.local.NewsDao
import uz.abdurashidov.newsapp.domain.model.Article
import javax.inject.Inject

class GetSavedArticles @Inject constructor(
    private val newsDao: NewsDao
) {

    operator fun invoke(): Flow<List<Article>> {
        return newsDao.getArticles()
    }

}