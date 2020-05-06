package com.example.mangadex.ui.character

import com.example.mangadex.interactor.CharacterInteractor
import com.example.mangadex.model.DummyContent
import com.example.mangadex.ui.Presenter
import java.util.concurrent.Executor
import javax.inject.Inject

class CharacterPresenter @Inject constructor(private val executor: Executor, private val characterInteractor: CharacterInteractor) : Presenter<CharacterScreen>() {

    fun showDummyChar(item: DummyContent) {
        this.screen?.showDummyCharacters(item)
    }

    fun getDummyChar(item: DummyContent) {
        showDummyChar(characterInteractor.getDummyCharacters(item))
    }

    /*
    override fun attachScreen(screen: CharacterScreen) {
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
