package com.example.mangadex.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "mangas")
data class MangaEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val mal_id: Int,
    val title: String,
    val url: String,
    val image_url: String,
    val score_Num: Int,
    val total_chapter: Int
)
