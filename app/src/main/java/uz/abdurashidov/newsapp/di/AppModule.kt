package uz.abdurashidov.newsapp.di

import android.app.Application
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.abdurashidov.newsapp.data.manager.LocalUserManagerImpl
import uz.abdurashidov.newsapp.domain.manager.LocalUserManager
import uz.abdurashidov.newsapp.domain.usecases.AppEntryUseCase
import uz.abdurashidov.newsapp.domain.usecases.ReadAppEntry
import uz.abdurashidov.newsapp.domain.usecases.SaveAppEntry
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
        readAppEntry = ReadAppEntry(localUserManager),
        saveAppEntry = SaveAppEntry(localUserManager)
    )
}