package uz.abdurashidov.newsapp.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import uz.abdurashidov.newsapp.data.remote.NewsApi
import uz.abdurashidov.newsapp.data.remote.NewsPagingSource
import uz.abdurashidov.newsapp.data.remote.SearchNewsPagingSource
import uz.abdurashidov.newsapp.domain.model.Article
import uz.abdurashidov.newsapp.domain.repository.NewsRepository

class NewsRepositoryImp(
    private val newsApi: NewsApi
) : NewsRepository {
    override fun getNews(source: List<String>): Flow<PagingData<Article>> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                NewsPagingSource(
                    newsApi = newsApi,
                    sources = source.joinToString(separator = ",")
                )
            }
        ).flow
    }

    //test
    override fun searchNews(searchQuery: String, source: List<String>): Flow<PagingData<Article>> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                SearchNewsPagingSource(
                    newsApi = newsApi,
                    sources = source.joinToString(separator = ","),
                    searchQuery = searchQuery
                )
            }
        ).flow
    }
}