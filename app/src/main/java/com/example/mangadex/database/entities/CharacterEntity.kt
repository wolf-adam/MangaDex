package com.example.mangadex.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "characters")
data class CharacterEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val character_name: String,
    val character_url: String,
    val chaacter_image_url: String
)
