package com.example.mangadex.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.mangadex.R
import com.example.mangadex.database.MangaDao
import com.example.mangadex.injector
import com.example.mangadex.model.Manga
import com.example.mangadex.ui.character.CharacterActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.manga_list.*
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainScreen, MainAdapter.Listener {

    @Inject
    lateinit var mainPresenter: MainPresenter

    private lateinit var mainAdapter: MainAdapter

    companion object {
        const val MAL_ID = "mal_id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        injector.inject(this)

        mainPresenter.attachScreen(this)

        mainAdapter = MainAdapter(this, this)
        manga_list.adapter = mainAdapter

        fab.setOnClickListener { v -> fabOnClickListener(v) }
 }

    private fun fabOnClickListener(view: View) {

        with(AlertDialog.Builder(view.context)) {
            setTitle("Enter MAL Username")
            val layout = layoutInflater.inflate(R.layout.add_username_dialog, null)
            val addUsernameContentET = layout.findViewById<EditText>(R.id.addUsernameContent_ET)
            setView(layout)
            setNegativeButton("Cancel", null)
            setPositiveButton("OK") { _, _ ->
                var username = addUsernameContentET.text.toString()
                if (username == "") {
                    username = "W3lfmann"
                }
                MainScope().launch {
                    mainPresenter.saveUser(username)
                    mainPresenter.getList(username)
                }
            }
            show()
        }

        runOnUiThread {
            fab.startAnimation(AnimationUtils.loadAnimation(applicationContext, R.anim.rotate_clockwise))
        }
    }

    override fun onStart() {
        super.onStart()
        mainPresenter.attachScreen(this)
    }

    override fun onStop() {
        super.onStop()
        mainPresenter.detachScreen()
    }

    override fun onItemClicked(mal_id: Long) {
        MainScope().launch {
                mainPresenter.refreshListElement(mal_id)
        }
    }

    override fun loadMangas(mangaList: List<Manga>) {
        runOnUiThread {
            Toast.makeText(this, "Loading mangas...", Toast.LENGTH_SHORT).show()

            mainAdapter.submitList(mangaList.distinctBy {it.title})
        }
    }

    override fun showDetails(mal_id: Long) {

        val intent = Intent(this, CharacterActivity::class.java).apply {
            putExtra(MAL_ID, mal_id)
        }
        startActivity(intent)
    }
}
