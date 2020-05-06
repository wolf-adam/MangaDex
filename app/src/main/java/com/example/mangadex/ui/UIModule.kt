package com.example.mangadex.ui

import android.content.Context
import com.example.mangadex.interactor.CharacterInteractor
import com.example.mangadex.interactor.MainInteractor
import com.example.mangadex.ui.character.CharacterPresenter
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
    fun cityPresenter(characterInteractor: CharacterInteractor) = CharacterPresenter(characterInteractor)

    @Provides
    @Singleton
    fun weatherPresenter(mainInteractor: MainInteractor) = MainPresenter(mainInteractor)
}