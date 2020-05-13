package com.example.mangadex.database.entities

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "characters_request")
data class CharacterRequestEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    @Embedded
    val characters: CharactersEntity
)
