package com.example.mangadex.ui.character

import android.util.Log
import com.example.mangadex.interactor.CharacterInteractor
import com.example.mangadex.ui.Presenter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CharacterPresenter constructor(private val characterInteractor: CharacterInteractor) : Presenter<CharacterScreen>() {

    override fun attachScreen(screen: CharacterScreen) {
        super.attachScreen(screen)
    }

    override fun detachScreen() {
        super.detachScreen()
    }

    suspend fun getList(mangaID: Long) = withContext(Dispatchers.IO) {
        var list = characterInteractor.getCharacters(mangaID)
        list.characters?.let { characterInteractor.saveCharacters(mangaID, it) }

        val result = characterInteractor.getAllCharacters()

        Log.d("getlist size",  result.size.toString())

        screen?.loadCharacters(result)
    }
/*
    suspend fun deleteCharacters(){
        characterInteractor.deleteCharacters()
    }*/
}
