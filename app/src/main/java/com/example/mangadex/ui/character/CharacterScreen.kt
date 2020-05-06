package com.example.mangadex.ui.character

interface CharacterScreen {
    fun showCharacterName(name: String)

    fun showCharacterCover(cover: Int)

    fun showRating(rate: Double)

    fun showDetail(detail: String)

    fun showAvailableChapters()
}