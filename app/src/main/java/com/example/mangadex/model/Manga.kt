package com.example.mangadex.model

data class Manga(
    var mal_id: Long? = null,
    var title: String? = null,
    var image_url: String? = null,
    var score: Int? = null,
    var total_chapters: Int? = null
)
