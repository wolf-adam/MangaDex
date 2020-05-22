package com.example.mangadex.interactor

import com.example.mangadex.database.MangaDao
import com.example.mangadex.database.entities.MangaEntity
import com.example.mangadex.database.entities.UserEntity
import com.example.mangadex.model.Manga
import com.example.mangadex.model.MangaResult
import com.example.mangadex.network.MangaApi
import javax.inject.Inject

class MainInteractor @Inject constructor(private var mangaApi: MangaApi, private var mangaDao: MangaDao) {

    suspend fun getMangas(username: String) : MangaResult {

        return mangaApi.getMangaList(username, "desc")

    }

    suspend fun getAllManga() : List<Manga> {

        return mangaDao.getAllMangas().map {
            Manga(it.mal_id, it.title, it.image_url, it.score_Num, it.total_chapter)
        }

    }

    suspend fun getMangaByID(mal_id: Long) : Long {

        return mangaDao.getMangaByID(mal_id).mal_id

    }

    suspend fun saveMangas(mangas: List<Manga>?) {
        mangas?.forEach {
                try {
                    mangaDao.addManga(
                        MangaEntity(
                            mal_id = it.mal_id!!,
                            title = it.title!!,
                            image_url = it.image_url!!,
                            score_Num = it.score!!,
                            total_chapter = it.total_chapters!!
                        )
                    )
                } catch (e: java.lang.Exception) {
                    e.printStackTrace()
                }
        }
    }

    suspend fun saveUser(username: String) {
        try {
            mangaDao.addUser(UserEntity(username=username))
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
    }
}
