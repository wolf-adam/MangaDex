package com.example.mangadex.ui.main

import com.example.mangadex.model.DummyContent

interface MainScreen {
    fun updateMainList()

    fun showNetworkError(msg: String)

    //Dummy
    fun showDummyMangas(item: DummyContent)
}