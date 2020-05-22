package com.example.mangadex

import com.example.mangadex.database.MangaDao
import com.example.mangadex.database.entities.MangaEntity
import com.example.mangadex.database.entities.UserEntity
import com.example.mangadex.interactor.MainInteractor
import com.example.mangadex.model.Manga
import com.example.mangadex.model.MangaResult
import com.example.mangadex.network.MangaApi
import io.mockk.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class MainInteractorTest {

    private lateinit var mangaApi: MangaApi
    private lateinit var mangaDao: MangaDao
    private lateinit var mainInteractor: MainInteractor

    @Before
    fun setUp() {
        mangaApi = mockk(relaxed = true)
        mangaDao = mockk(relaxed = true)

        mainInteractor = MainInteractor(mangaApi, mangaDao)

        clearAllMocks()
    }


    @Test
    fun getMangas() = runBlocking {

        val mangaID : Long = 1
        val username = "W3lfmann"
        val title  = "Kimetsu no Yaiba"
        val imageUrl = "https://cdn.myanimelist.net/images/manga/3/179023.jpg?s=d397a830b830411cd0e397c72ac3213b"
        val score = 10
        val totalChapters = 42
        val mangaList = listOf(Manga(mangaID, title, imageUrl, score , totalChapters))

        coEvery {
            mangaApi.getMangaList(username, "desc")
        } returns MangaResult(mangaList)

        mainInteractor.getMangas(username)

        coVerify {  mangaApi.getMangaList(username, "desc")}
        confirmVerified(mangaApi)
    }

    @Test
    fun getAllManga() = runBlocking {

        mainInteractor.getAllManga()

        coVerify { mangaDao.getAllMangas()}
        confirmVerified(mangaDao)
    }

    @Test
    fun getMangaByID()  = runBlocking {
        val mangaID : Long = 1
        val title  = "Kimetsu no Yaiba"
        val imageUrl = "https://cdn.myanimelist.net/images/manga/3/179023.jpg?s=d397a830b830411cd0e397c72ac3213b"
        val score = 10
        val totalChapters = 42
        val mangaEnt = MangaEntity(mangaID, title, imageUrl, score , totalChapters)

        coEvery {
            mangaDao.getMangaByID(mangaID)
        } returns mangaEnt

        mainInteractor.getMangaByID(mangaID)

        coVerify { mangaDao.getMangaByID(mangaID) }
        confirmVerified(mangaDao)
    }

    @Test
    fun saveMangas()  = runBlocking {
        val mangaID : Long = 1
        val title  = "Kimetsu no Yaiba"
        val imageUrl = "https://cdn.myanimelist.net/images/manga/3/179023.jpg?s=d397a830b830411cd0e397c72ac3213b"
        val score = 10
        val totalChapters = 42
        val mangaEnt = MangaEntity(mangaID, title, imageUrl, score , totalChapters)
        val mangaList = listOf(Manga(mangaID, title, imageUrl, score , totalChapters))

        mainInteractor.saveMangas(mangaList)

        coVerify { mangaDao.addManga(mangaEnt)}
        confirmVerified(mangaDao)
    }

    @Test
    fun saveUser()  = runBlocking {

        val username = "W3lfmann"

        mainInteractor.saveUser(username)

        coVerify { mangaDao.addUser(UserEntity(username))}
        confirmVerified(mangaDao)
    }
}
