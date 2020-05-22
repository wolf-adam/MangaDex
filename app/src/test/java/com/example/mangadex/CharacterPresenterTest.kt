package com.example.mangadex

import com.example.mangadex.interactor.CharacterInteractor
import com.example.mangadex.ui.character.CharacterPresenter
import com.example.mangadex.ui.character.CharacterScreen
import com.example.mangadex.model.Character
import com.example.mangadex.model.CharacterResult
import io.mockk.*
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class CharacterPresenterTest {

    private lateinit var presenter: CharacterPresenter
    private lateinit var characterInteractor: CharacterInteractor
    private lateinit var screen: CharacterScreen

    @Before
    fun init() {
        characterInteractor = mockk(relaxed = true)
        screen = mockk(relaxed = true)

        presenter = CharacterPresenter(characterInteractor)
        presenter.attachScreen(screen)

        clearAllMocks()
    }

    @Test
    fun getList() = runBlocking {
        // Test values
        val mangaID : Long = 1
        val malID: Long = 146157
        val url ="https://myanimelist.net/character/146157/Nezuko_Kamado"
        val imageUrl = "https://cdn.myanimelist.net/images/characters/15/384829.jpg"
        val name = "Nezuko, Kamado"
        val role = "Main"
        val characterList = listOf(Character(malID, url, imageUrl, name, role))

        coEvery {
            characterInteractor.getCharacters(mangaID)
        } returns CharacterResult(characterList)

        coEvery {
            characterInteractor.getAllCharacters(mangaID)
        } returns characterList

        presenter.getList(mangaID)

        coVerify { characterInteractor.getCharacters(mangaID) }
        coVerify { characterInteractor.saveCharacters(mangaID, characterList) }
        coVerify { characterInteractor.getAllCharacters(mangaID) }
        coVerify { screen.loadCharacters(characterList) }

        confirmVerified(characterInteractor)
        confirmVerified(screen)
    }
}