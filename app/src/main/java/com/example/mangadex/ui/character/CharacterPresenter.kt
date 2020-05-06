package com.example.mangadex.ui.character

import com.example.mangadex.interactor.CharacterInteractor
import com.example.mangadex.ui.Presenter
import javax.inject.Inject

class CharacterPresenter @Inject constructor(private val characterInteractor: CharacterInteractor) : Presenter<CharacterScreen>() {
    override fun attachScreen(screen: CharacterScreen) {
        super.attachScreen(screen)
    }

    override fun detachScreen() {
        super.detachScreen()
    }

    fun refreshTriggered() {
        TODO()
    }
}
