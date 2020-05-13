package com.example.mangadex.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.mangadex.database.entities.MangaEntity
import com.example.mangadex.database.entities.CharacterRequestEntity
import com.example.mangadex.database.entities.CharactersEntity

@Database(
    exportSchema = false,
    version = 1,
    entities = [
        MangaEntity::class,
        CharacterRequestEntity::class,
        CharactersEntity::class
    ]
)
abstract class MangaDatabase : RoomDatabase() {
    abstract fun mangaDao(): MangaDao
}
