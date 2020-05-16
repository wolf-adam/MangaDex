package com.example.mangadex.interactor

import android.util.Log
import com.example.mangadex.database.MangaDao
import com.example.mangadex.model.Character
import com.example.mangadex.model.DummyContent
import com.example.mangadex.network.MangaApi
import javax.inject.Inject

class CharacterInteractor @Inject constructor(private var mangaApi: MangaApi, private var mangaDao: MangaDao) {


    // Dummy
    fun getDummyCharacters(item: DummyContent): DummyContent {
        return item
    }

    /*
    suspend fun getCharacters(mangaID: Long) : List<Character>{

        return try {
            val characters = mangaApi.getCharacters(mangaID);
            characters.forEach{
                Log.d("load_mangas", "Mangas loaded: $it")
            }
        } catch (e: Error) {
            Log.e("network", "getCharacters Failed", e)
            emptyList()
        }
    }
    */
}
