package com.example.mangadex.ui.chapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import com.example.mangadex.R
import com.example.mangadex.chapterInjector
import javax.inject.Inject

class ChapterActivity : AppCompatActivity(), ChapterScreen {
    @Inject
    lateinit var chapterPresenter: ChapterPresenter

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_chapter)
        chapterInjector.inject(this)
        chapterPresenter.attachScreen(this)
    }

    override fun onStart() {
        super.onStart()
        chapterPresenter.attachScreen(this)
    }

    override fun onStop() {
        super.onStop()
        chapterPresenter.detachScreen()
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