package com.example.mangadex.network

import com.example.mangadex.model.CharacterResult
import com.example.mangadex.model.MangaResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MangaApi {
    @GET("{username}/mangalist/all/")
    fun getMangaList(
        @Path("username") username: String,
        @Query("order_by") order_by: String
    ): Call<List<MangaResult>>

    @GET("manga/{mal_id}/characters")
    fun getCharacters(
        @Path("mal_id") mal_id: String
    ): Call<List<CharacterResult>>
}
