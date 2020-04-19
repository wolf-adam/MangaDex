package com.example.mangadex.interactor

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class InteractorModule {
    @Provides
    @Singleton
    fun provideChapterInteractor() = ChapterInteractor()

    @Provides
    @Singleton
    fun provideMainInteractor() = MainInteractor()
}
