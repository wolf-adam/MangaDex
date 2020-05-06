package com.example.mangadex.interactor.event

import com.example.mangadex.model.MangaResult

data class GetMangaEvent (
    var code: Int = 0,
    var mal_id: Int? = null,
    var title: String? = null,
    var url: String? = null,
    var image_url: String? = null,
    var score_Num: Int? = null,
    var total_chapter: Int? = null,
    var throwable: Throwable? = null
)
