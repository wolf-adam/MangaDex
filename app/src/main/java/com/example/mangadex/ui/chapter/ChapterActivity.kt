package com.example.mangadex.ui.chapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import com.example.mangadex.R

class ChapterActivity : AppCompatActivity(), ChapterScreen {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_chapter)
    }

    override fun onStart() {
        super.onStart()
        ChapterPresenter.attachScreen(this)
    }

    override fun onStop() {
        super.onStop()
        ChapterPresenter.detachScreen()
    }

    override fun showChapterCover(cover: Int) {
        TODO("Not yet implemented")
    }

    override fun showChapterName(name: String) {
        TODO("Not yet implemented")
    }

    override fun showRating(rate: Double) {
        TODO("Not yet implemented")
    }

    override fun showDetail(detail: String) {
        TODO("Not yet implemented")
    }

    override fun showAvailableChapters() {
        TODO("Not yet implemented")
    }
}