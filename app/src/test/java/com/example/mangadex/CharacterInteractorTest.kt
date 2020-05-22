package com.example.mangadex

import com.example.mangadex.database.MangaDao
import com.example.mangadex.database.entities.CharactersEntity
import com.example.mangadex.interactor.CharacterInteractor
import com.example.mangadex.network.MangaApi
import com.example.mangadex.model.Character
import com.example.mangadex.model.CharacterResult
import io.mockk.*
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class CharacterInteractorTest {

    private lateinit var mangaApi: MangaApi
    private lateinit var mangaDao: MangaDao
    private lateinit var chapterInteractor: CharacterInteractor

    @Before
    fun init() {
        mangaApi = mockk(relaxed = true)
        mangaDao = mockk(relaxed = true)

        chapterInteractor = CharacterInteractor(mangaApi, mangaDao)

        clearAllMocks()
    }

    @Test
    fun getCharacters()= runBlocking {

        val mangaID : Long = 1
        val malID: Long = 146157
        val url ="https://myanimelist.net/character/146157/Nezuko_Kamado"
        val imageUrl = "https://cdn.myanimelist.net/images/characters/15/384829.jpg"
        val name = "Nezuko, Kamado"
        val role = "Main"
        val characterList = listOf(Character(malID, url, imageUrl, name, role))

        coEvery {
            mangaApi.getCharacters(mangaID)
        } returns CharacterResult(characterList)

        chapterInteractor.getCharacters(mangaID)

        coVerify { mangaApi.getCharacters(mangaID)}
        confirmVerified(mangaApi)
    }

    @Test
    fun getAllCharacters() = runBlocking {

        val mangaID : Long = 1
        val malID: Long = 146157
        val url ="https://myanimelist.net/character/146157/Nezuko_Kamado"
        val imageUrl = "https://cdn.myanimelist.net/images/characters/15/384829.jpg"
        val name = "Nezuko, Kamado"
        val role = "Main"
        val charEnt = CharactersEntity(malID, mangaID, url, imageUrl, name , role)

        coEvery {
            mangaDao.getCharactersByMangaID(mangaID)
        } returns listOf(charEnt)

        chapterInteractor.getAllCharacters(mangaID)

        coVerify { mangaDao.getCharactersByMangaID(mangaID)}
        confirmVerified(mangaDao)
    }

    @Test
    fun saveCharacters() = runBlocking {

        val mangaID : Long = 1
        val malID: Long = 146157
        val url ="https://myanimelist.net/character/146157/Nezuko_Kamado"
        val imageUrl = "https://cdn.myanimelist.net/images/characters/15/384829.jpg"
        val name = "Nezuko, Kamado"
        val role = "Main"
        val charEnt = CharactersEntity(malID, mangaID, url, imageUrl, name , role)
        val characterList = listOf(Character(malID, url, imageUrl, name, role))

        chapterInteractor.saveCharacters(mangaID, characterList)

        coVerify { mangaDao.addCharacter(charEnt)}
        confirmVerified(mangaDao)
    }
}
