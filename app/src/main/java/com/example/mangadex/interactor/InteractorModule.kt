package com.example.mangadex.interactor

import com.example.mangadex.network.MangaApi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class InteractorModule {
    @Provides
    @Singleton
    fun provideCharacterInteractor(mangaApi: MangaApi) = CharacterInteractor(mangaApi)

    @Provides
    @Singleton
    fun provideMainInteractor() = MainInteractor()
}
