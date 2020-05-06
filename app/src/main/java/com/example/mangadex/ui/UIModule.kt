package com.example.mangadex.ui

import android.content.Context
import com.example.mangadex.interactor.CharacterInteractor
import com.example.mangadex.interactor.MainInteractor
import com.example.mangadex.ui.character.CharacterPresenter
import com.example.mangadex.ui.main.MainPresenter
import dagger.Module
import dagger.Provides
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import javax.inject.Singleton

@Module
class UIModule (private val context: Context){
    @Provides
    fun context() = context

    @Provides
    @Singleton
    fun characterPresenter(executor: Executor, characterInteractor: CharacterInteractor) = CharacterPresenter(executor, characterInteractor)

    @Provides
    @Singleton
    fun mainPresenter(executor: Executor,mainInteractor: MainInteractor) = MainPresenter(executor, mainInteractor)

    @Provides
    @Singleton
    fun networkExecutor(): Executor = Executors.newFixedThreadPool(1)
}