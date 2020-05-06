package com.example.mangadex.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.mangadex.database.entities.MangaEntity
import com.example.mangadex.database.entities.CharacterEntity

@Database(
    exportSchema = false,
    version = 1,
    entities = [
        MangaEntity::class,
        CharacterEntity::class
    ]
)
abstract class MangaDatabase : RoomDatabase() {

    abstract fun mangaDao(): MangaDao

}
