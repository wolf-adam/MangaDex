package com.example.mangadex.network

import com.example.mangadex.model.CharacterRequestResult
import com.example.mangadex.model.MangaRequestResult
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MangaApi {
    @GET("user/{username}/mangalist/all/")
    suspend fun getMangaList(
        @Path("username") username: String,
        @Query("order_by") order_by: String
    ): List<MangaRequestResult>

    @GET("manga/{mal_id}/characters")
    suspend fun getCharacters(
        @Path("mal_id") mal_id: Long
    ): List<CharacterRequestResult>
}
