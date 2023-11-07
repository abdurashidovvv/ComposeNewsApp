package uz.abdurashidov.newsapp.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import uz.abdurashidov.newsapp.data.local.NewsDao
import uz.abdurashidov.newsapp.data.local.NewsDatabase
import uz.abdurashidov.newsapp.data.local.NewsTypeConvertor
import uz.abdurashidov.newsapp.data.manager.LocalUserManagerImpl
import uz.abdurashidov.newsapp.data.remote.NewsApi
import uz.abdurashidov.newsapp.data.repository.NewsRepositoryImp
import uz.abdurashidov.newsapp.domain.manager.LocalUserManager
import uz.abdurashidov.newsapp.domain.repository.NewsRepository
import uz.abdurashidov.newsapp.domain.usecases.appentry.AppEntryUseCase
import uz.abdurashidov.newsapp.domain.usecases.appentry.ReadAppEntry
import uz.abdurashidov.newsapp.domain.usecases.appentry.SaveAppEntry
import uz.abdurashidov.newsapp.domain.usecases.news.DeleteArticle
import uz.abdurashidov.newsapp.domain.usecases.news.GetNews
import uz.abdurashidov.newsapp.domain.usecases.news.NewsUseCases
import uz.abdurashidov.newsapp.domain.usecases.news.SearchNews
import uz.abdurashidov.newsapp.domain.usecases.news.SelectArticle
import uz.abdurashidov.newsapp.domain.usecases.news.SelectArticles
import uz.abdurashidov.newsapp.domain.usecases.news.UpsertArticle
import uz.abdurashidov.newsapp.utils.Constants.BASE_URL
import uz.abdurashidov.newsapp.utils.Constants.NEWS_DATABASE_NAME
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManger(
        application: Application
    ): LocalUserManager = LocalUserManagerImpl(application)

    @Provides
    @Singleton
    fun provideAppEntryUseCases(
        localUserManager: LocalUserManager
    ) = AppEntryUseCase(
        readAppEntry = ReadAppEntry(localUserManager), saveAppEntry = SaveAppEntry(localUserManager)
    )

    @Provides
    @Singleton
    fun provideNewsApi(): NewsApi {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build().create(NewsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideNewsRepository(
        newsApi: NewsApi
    ): NewsRepository = NewsRepositoryImp(newsApi)

    @Provides
    @Singleton
    fun provideNewsUseCases(
        newsRepository: NewsRepository,
        newsDao: NewsDao
    ): NewsUseCases {
        return NewsUseCases(
            getNews = GetNews(newsRepository),
            searchNews = SearchNews(newsRepository),
            upsertArticle = UpsertArticle(newsDao),
            deleteArticle = DeleteArticle(newsDao),
            selectArticles = SelectArticles(newsDao),
            selectArticle = SelectArticle(newsDao)
        )
    }


    @Provides
    @Singleton
    fun provideNewsDatabase(
        application: Application
    ): NewsDatabase {
        return Room.databaseBuilder(
            context = application.applicationContext,
            klass = NewsDatabase::class.java,
            name = NEWS_DATABASE_NAME
        ).addTypeConverter(NewsTypeConvertor()).fallbackToDestructiveMigration().build()
    }

    @Provides
    @Singleton
    fun provideNewsDao(
        newsDatabase: NewsDatabase
    ): NewsDao = newsDatabase.newsDao
}