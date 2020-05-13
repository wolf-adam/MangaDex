package com.example.mangadex.interactor

import android.util.Log
import com.example.mangadex.database.MangaDao
import com.example.mangadex.interactor.event.GetCharacterEvent
import com.example.mangadex.model.DummyContent
import com.example.mangadex.network.MangaApi
import org.greenrobot.eventbus.EventBus
import javax.inject.Inject

class CharacterInteractor @Inject constructor(private var mangaApi: MangaApi, private var mangaDao: MangaDao) {


    // Dummy
    fun getDummyCharacters(item: DummyContent): DummyContent {
        return item
    }

    fun getCharacters(mangaID: String) {

        val event = GetCharacterEvent()

        try {
            val characterQueryCall = mangaApi.getCharacters(mangaID);
            val response = characterQueryCall.execute()
            Log.d("Response", response.body().toString())

            if (response.code() != 200) {
                throw Exception("Result code is not 200")
            }

            event.code = response.code()
            event.characters = response.body()?.character_request?.characters

            EventBus.getDefault().post(event)
        } catch (e: Exception) {
            event.throwable = e
            EventBus.getDefault().post(event)
        }
    }
}
