package com.example.mangadex.ui.character

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import com.example.mangadex.R
import com.example.mangadex.characterInjector
import com.example.mangadex.model.DummyContent
import javax.inject.Inject

class CharacterActivity : AppCompatActivity(), CharacterScreen {
    @Inject
    lateinit var characterPresenter: CharacterPresenter

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_character)
        characterInjector.inject(this)
        characterPresenter.attachScreen(this)
    }

    override fun onStart() {
        super.onStart()
        characterPresenter.attachScreen(this)
    }

    override fun onStop() {
        super.onStop()
        characterPresenter.detachScreen()
    }

    override fun showCharacterName(name: String) {
        TODO("Not yet implemented")
    }

    override fun showCharacterCover(cover: Int) {
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