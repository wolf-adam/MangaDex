package com.example.mangadex.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "characters")
data class CharactersEntity (
    @PrimaryKey
    val mal_id: Long,

    val manga_id: Long,
    val url: String,
    val image_url: String,
    val name: String,
    val role: String
)
