package com.example.mangadex.ui.main

import com.example.mangadex.interactor.MainInteractor
import com.example.mangadex.ui.Presenter
import javax.inject.Inject

class MainPresenter @Inject constructor(private val mainInteractor: MainInteractor) : Presenter<MainScreen>() {
    override fun attachScreen(screen: MainScreen) {
        super.attachScreen(screen)
    }

    override fun detachScreen() {
        super.detachScreen()
    }

    fun refreshTriggered() {
        TODO()
    }
}