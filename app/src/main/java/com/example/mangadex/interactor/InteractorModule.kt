package com.example.mangadex.interactor

import com.example.mangadex.database.MangaDao
import com.example.mangadex.network.MangaApi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class InteractorModule {
    @Provides
    @Singleton
    fun provideCharacterInteractor(mangaApi: MangaApi, mangaDao: MangaDao) = CharacterInteractor(mangaApi, mangaDao)

    @Provides
    @Singleton
    fun provideMainInteractor(mangaApi: MangaApi, mangaDao: MangaDao) = MainInteractor(mangaApi, mangaDao)
}
