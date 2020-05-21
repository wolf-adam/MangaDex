package com.example.mangadex.interactor

import android.util.Log
import com.example.mangadex.database.MangaDao
import com.example.mangadex.database.entities.CharactersEntity
import com.example.mangadex.interactor.event.GetCharacterEvent
import com.example.mangadex.model.Character
import com.example.mangadex.network.MangaApi
import javax.inject.Inject

class CharacterInteractor @Inject constructor(private var mangaApi: MangaApi, private var mangaDao: MangaDao) {

    suspend fun getCharacters(mangaID: Long) : GetCharacterEvent {

        val event = GetCharacterEvent()
        val response = mangaApi.getCharacters(mangaID)
        event.characters = response.characters

        return event
    }

    suspend fun getAllCharacters(mangaID: Long) : List<Character> {

        return mangaDao.getCharactersByMangaID(mangaID).map {
            Character(it.mal_id, it.url, it.image_url, it.name, it.role)
        }

    }

    suspend fun saveCharacters(mangaID: Long, mangas: List<Character>?) {
        mangas?.forEach {
            try {
                mangaDao.addCharacter(
                    CharactersEntity(
                        mal_id = it.mal_id!!,
                        manga_id = mangaID,
                        url = it.url!!,
                        image_url = it.image_url!!,
                        name = it.name!!,
                        role = it.role!!
                    )
                )
            } catch (e: java.lang.Exception) {
                e.printStackTrace()
            }
        }
    }

    suspend fun deleteCharacters(){
        mangaDao.deleteCharacterDB()
    }
}
