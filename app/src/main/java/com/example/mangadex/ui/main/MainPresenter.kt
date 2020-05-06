package com.example.mangadex.ui.main

import com.example.mangadex.interactor.MainInteractor
import com.example.mangadex.model.DummyContent
import com.example.mangadex.ui.Presenter
import java.util.concurrent.Executor
import javax.inject.Inject

class MainPresenter @Inject constructor(private val executor: Executor, private val mainInteractor: MainInteractor) : Presenter<MainScreen>() {

    fun showDummyMang(item: DummyContent) {
        this.screen?.showDummyMangas(item)
    }

    fun getDummyMang(item: DummyContent) {
        showDummyMang(mainInteractor.getDummyMangas(item))
    }

    /*
    override fun attachScreen(screen: MainScreen) {
        super.attachScreen(screen)
    }

    override fun detachScreen() {
        super.detachScreen()
    }

    fun refreshTriggered() {
        TODO()
    }
     */
}