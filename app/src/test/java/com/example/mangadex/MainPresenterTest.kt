package com.example.mangadex

import com.example.mangadex.interactor.MainInteractor
import com.example.mangadex.model.Manga
import com.example.mangadex.model.MangaResult
import com.example.mangadex.ui.main.MainPresenter
import com.example.mangadex.ui.main.MainScreen
import io.mockk.*
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class MainPresenterTest {

    private lateinit var presenter: MainPresenter
    private lateinit var mainInteractor: MainInteractor
    private lateinit var screen: MainScreen

    @Before
    fun init() {
        mainInteractor = mockk(relaxed = true)
        screen = mockk(relaxed = true)

        presenter = MainPresenter(mainInteractor)
        presenter.attachScreen(screen)

        clearAllMocks()
    }

    @Test
    fun refreshListElement() = runBlocking{

        val mal_id : Long = 1

        coEvery {
            mainInteractor.getMangaByID(mal_id)
        } returns mal_id

        presenter.refreshListElement(mal_id)

        coVerify { mainInteractor.getMangaByID(mal_id)}
        coVerify { screen.showDetails(mal_id)}

        confirmVerified(mainInteractor)

    }

    @Test
    fun getList() = runBlocking {
        // Test values
        val mangaID : Long = 1
        val username = "W3lfmann"
        val title  = "Kimetsu no Yaiba"
        val imageUrl = "https://cdn.myanimelist.net/images/manga/3/179023.jpg?s=d397a830b830411cd0e397c72ac3213b"
        val score = 10
        val totalChapters = 42
        val mangaList = listOf(Manga(mangaID, title, imageUrl, score , totalChapters))

        coEvery {
            mainInteractor.getMangas(username)
        } returns MangaResult(mangaList)

        coEvery {
            mainInteractor.getAllManga()
        } returns mangaList

        presenter.getList(username)

        coVerify { mainInteractor.getMangas(username) }
        coVerify { mainInteractor.saveMangas(mangaList) }
        coVerify { mainInteractor.getAllManga() }
        coVerify { screen.loadMangas(mangaList) }

        confirmVerified(mainInteractor)
        confirmVerified(screen)
    }

    @Test
    fun saveUser() = runBlocking{
        val username = "Hiro"

        presenter.saveUser(username)

        coVerify { mainInteractor.saveUser(username)}

        confirmVerified(mainInteractor)
    }
}