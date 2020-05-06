package com.example.mangadex.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.example.mangadex.database.entities.MangaEntity
import com.example.mangadex.database.entities.CharacterEntity

@Dao
interface MangaDao {
    @Query("SELECT * FROM mangas")
    fun getAllMangas(): List<MangaEntity>

    @Insert(onConflict = REPLACE)
    fun addManga(projectEntity: MangaEntity)

    @Query("SELECT * FROM characters")
    fun getAllCharacters(): List<CharacterEntity>

    @Insert(onConflict = REPLACE)
    fun addCharacter(taskEntity: CharacterEntity)
}
