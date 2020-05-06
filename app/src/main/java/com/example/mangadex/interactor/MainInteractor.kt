package com.example.mangadex.interactor

import android.util.Log
import com.example.mangadex.database.MangaDao
import com.example.mangadex.interactor.event.GetMangaEvent
import com.example.mangadex.model.DummyContent
import com.example.mangadex.network.NetworkConfig
import com.example.mangadex.network.MangaApi
import org.greenrobot.eventbus.EventBus
import javax.inject.Inject

class MainInteractor @Inject constructor(mangaApi: MangaApi, mangaDao: MangaDao) {

    //Dummy
    fun getDummyMangas(item: DummyContent): DummyContent {
        return item
    }

    /*
    fun getCoordinates(cityName: String) {

        val event = GetCoordinatesByCityEvent()

        try {
            val coordinatesQueryCall = weatherApi.getCoordinatesByCity(cityName, NetworkConfig.API_KEY)
            val response = coordinatesQueryCall.execute()
            Log.d("Response", response.body().toString())

            if (response.code() != 200) {
                throw Exception("Result code is not 200")
            }

            event.code = response.code()
            event.cityName = response.body()?.cityName
            event.lat = response.body()?.lat
            event.lon = response.body()?.lon
            event.temperature = response.body()?.temperature

            EventBus.getDefault().post(event)
        } catch (e: Exception) {
            event.throwable = e
            EventBus.getDefault().post(event)
        }
    }
    */
}
