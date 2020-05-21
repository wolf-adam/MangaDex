package com.example.mangadex.interactor.event

import com.example.mangadex.model.Manga

data class GetMangaEvent (
    var code: Int = 0,
    var mangas: List<Manga>? = null,
    var throwable: Throwable? = null
)
