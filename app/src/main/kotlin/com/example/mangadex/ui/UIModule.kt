package com.example.mangadex.ui

import android.content.Context
import com.example.mangadex.interactor.ChapterInteractor
import com.example.mangadex.interactor.MainInteractor
import com.example.mangadex.ui.chapter.ChapterPresenter
import com.example.mangadex.ui.main.MainPresenter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UIModule (private val context: Context){
    @Provides
    fun context() = context

    @Provides
    @Singleton
    fun cityPresenter(chapterInteractor: ChapterInteractor) = ChapterPresenter(chapterInteractor)

    @Provides
    @Singleton
    fun weatherPresenter(mainInteractor: MainInteractor) = MainPresenter(mainInteractor)
}