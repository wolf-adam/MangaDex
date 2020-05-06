package com.example.mangadex.ui.chapter

import com.example.mangadex.interactor.ChapterInteractor
import com.example.mangadex.ui.Presenter
import javax.inject.Inject

class ChapterPresenter @Inject constructor(private val chapterInteractor: ChapterInteractor) : Presenter<ChapterScreen>() {
    override fun attachScreen(screen: ChapterScreen) {
        super.attachScreen(screen)
    }

    override fun detachScreen() {
        super.detachScreen()
    }

    fun refreshTriggered() {
        TODO()
    }
}
