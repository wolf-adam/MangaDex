package com.example.mangadex.ui.main

import com.example.mangadex.model.Manga

interface MainScreen {

    fun loadMangas(mangaList: List<Manga>)

    fun showDetails(mal_id: Long)
}
