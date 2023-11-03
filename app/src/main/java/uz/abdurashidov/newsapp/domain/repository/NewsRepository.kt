package uz.abdurashidov.newsapp.domain.repository

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import uz.abdurashidov.newsapp.domain.model.Article

interface NewsRepository {
    fun getNews(source: List<String>): Flow<PagingData<Article>>
}