package com.example.mangadex.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "mangas")
data class MangaEntity (
    @PrimaryKey
    val mal_id: Long,    // MyAnimeList ID, every manga has this unique ID

    val title: String,
    val image_url: String,
    val score_Num: Int,
    val total_chapter: Int
)
