package com.example.mangadex.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mangadex.database.entities.CharactersEntity
import com.example.mangadex.database.entities.MangaEntity
import com.example.mangadex.database.entities.UserEntity

@Database(
    exportSchema = false,
    version = 6,
    entities = [
        MangaEntity::class,
        CharactersEntity::class,
        UserEntity::class
    ]
)
abstract class MangaDatabase : RoomDatabase() {
    abstract fun mangaDao(): MangaDao
}
