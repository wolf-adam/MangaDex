package com.example.mangadex.ui.character

import com.example.mangadex.model.DummyContent

interface CharacterScreen {
    fun showCharacterName(name: String)

    fun showCharacterCover(cover: Int)

    fun showRating(rate: Double)

    fun showDetail(detail: String)

    fun showAvailableChapters()

    fun showNetworkError(msg: String)

    //Dummy
    fun showDummyCharacters(item: DummyContent)
}