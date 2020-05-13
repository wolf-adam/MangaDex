package com.example.mangadex.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.example.mangadex.database.entities.CharacterRequestEntity
import com.example.mangadex.database.entities.MangaEntity
import com.example.mangadex.database.entities.CharactersEntity

@Dao
interface MangaDao {
    @Query("SELECT * FROM mangas")
    fun getAllMangas(): List<MangaEntity>

    @Insert(onConflict = REPLACE)
    fun addManga(mangaEntity: MangaEntity)

    @Query("SELECT * FROM characters_request WHERE id=:id")
    fun getCharactersByMangaID(id: Int): List<CharactersEntity>

    @Insert(onConflict = REPLACE)
    fun addCharacters(characterRequestEntity: CharacterRequestEntity)
}
