package com.example.mangadex.ui.main

import com.example.mangadex.interactor.MainInteractor
import com.example.mangadex.ui.Presenter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MainPresenter constructor(private val mainInteractor: MainInteractor) : Presenter<MainScreen>() {

    override fun attachScreen(screen: MainScreen) {
        super.attachScreen(screen)
    }

    override fun detachScreen() {
        super.detachScreen()
    }

    suspend fun refreshListElement(mal_id: Long) = withContext(Dispatchers.IO) {
        var listResult = mainInteractor.getMangaByID(mal_id)
        screen?.showDetails(listResult)

    }

    suspend fun getList(username: String) = withContext(Dispatchers.IO) {
        var list = mainInteractor.getMangas(username)
        list.mangas?.let { mainInteractor.saveMangas(it) }

        val result = mainInteractor.getAllManga()

        screen?.loadMangas(result)

    }

    suspend fun saveUser(username: String) = withContext(Dispatchers.IO) {
        mainInteractor.saveUser(username)
    }
}
