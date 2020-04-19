package com.example.mangadex.ui.chapter

interface ChapterScreen {
    fun showChapterName(name: String)

    fun showChapterCover(cover: Int)

    fun showRating(rate: Double)

    fun showDetail(detail: String)

    fun showAvailableChapters()
}