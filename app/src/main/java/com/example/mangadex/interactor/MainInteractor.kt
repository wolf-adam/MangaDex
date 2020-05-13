package com.example.mangadex.interactor

import android.util.Log
import com.example.mangadex.database.MangaDao
import com.example.mangadex.interactor.event.GetMangaEvent
import com.example.mangadex.model.DummyContent
import com.example.mangadex.network.MangaApi
import org.greenrobot.eventbus.EventBus
import javax.inject.Inject

class MainInteractor @Inject constructor(private var mangaApi: MangaApi, private var mangaDao: MangaDao) {

    // Dummy
    fun getDummyMangas(item: DummyContent): DummyContent {
        return item
    }

    fun getMangaList(username: String) {

        val event = GetMangaEvent()


        try {
            // TODO: Hardcoded,should get it from user on UI
            // val mangasQueryCall = mangaApi.getMangaList(username, order_by)
            val mangasQueryCall = mangaApi.getMangaList("W3lfmann", "desc")
            val response = mangasQueryCall.execute()
            Log.d("Response", response.body().toString())

            if (response.code() != 200) {
                throw Exception("Result code is not 200")
            }

            event.code = response.code()
            event.mangas = response.body()?.manga_request?.manga

            EventBus.getDefault().post(event)
        } catch (e: Exception) {
            event.throwable = e
            EventBus.getDefault().post(event)
        }
    }
}
