package com.example.mangadex.interactor

import android.util.Log
import com.example.mangadex.database.MangaDao
import com.example.mangadex.model.DummyContent
import com.example.mangadex.model.Manga
import com.example.mangadex.network.MangaApi
import javax.inject.Inject

class MainInteractor @Inject constructor(private var mangaApi: MangaApi, private var mangaDao: MangaDao) {

    // Dummy
    fun getDummyMangas(item: DummyContent): DummyContent {
        return item
    }

    /*
    suspend fun getMangaList(username: String): List<Manga> {

        return try {
            // TODO: Hardcoded,should get it from user on UI
            // val mangas = mangaApi.getMangaList(username, order_by)
            val mangas = mangaApi.getMangaList("W3lfmann", "desc")
            mangas.forEach{
                Log.d("load_mangas", "Mangas loaded: $it")
            }
        } catch (e: Error) {
            Log.e("network", "getMangaList Failed", e)
            emptyList()
        }
    }
     */
}
