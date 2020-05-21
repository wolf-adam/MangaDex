package com.example.mangadex.ui.character

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.mangadex.R
import com.example.mangadex.injector
import com.example.mangadex.model.Character
import com.example.mangadex.ui.main.MainActivity
import com.example.mangadex.ui.main.MainAdapter
import kotlinx.android.synthetic.main.character_list.*
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class CharacterActivity : AppCompatActivity(), CharacterScreen, CharacterAdapter.Listener {

    @Inject
    lateinit var characterPresenter: CharacterPresenter

    private lateinit var characterAdapter: CharacterAdapter

    companion object {
        const val MAL_ID = "mal_id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character)
        injector.inject(this)

        characterPresenter.attachScreen(this)

        characterAdapter = CharacterAdapter(this, this)
        character_list.adapter = characterAdapter

        val mangaID: Long? = intent.extras?.getLong(MAL_ID)

        MainScope().launch {
            characterPresenter.getList(mangaID!!)
        }
    }

    override fun onStart() {
        super.onStart()
        characterPresenter.attachScreen(this)
    }

    override fun onStop() {
        super.onStop()

        /*MainScope().launch {
            characterPresenter.deleteCharacters()
        }*/

        characterPresenter.detachScreen()
    }

    override fun loadCharacters(character_List: List<Character>) {

        runOnUiThread {
            Toast.makeText(this,"Loading characters...", Toast.LENGTH_SHORT).show()
            characterAdapter.submitList(character_List.distinctBy {it.mal_id})
        }
    }

    override fun onItemClicked(mal_id: Long) {
        TODO("Not yet implemented")
    }


}