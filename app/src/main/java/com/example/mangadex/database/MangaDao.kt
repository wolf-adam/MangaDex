package com.example.mangadex.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.example.mangadex.database.entities.CharactersEntity
import com.example.mangadex.database.entities.MangaEntity
import com.example.mangadex.database.entities.UserEntity

@Dao
interface MangaDao {
    @Query("SELECT * FROM mangas")
    fun getAllMangas(): List<MangaEntity>

    @Query("SELECT * FROM mangas WHERE mal_id=:mal_id")
    fun getMangaByID(mal_id: Long): MangaEntity

    @Insert(onConflict = REPLACE)
    fun addManga(mangaEntity: MangaEntity)

    @Query("SELECT * FROM characters")
    fun getAllCharacters(): List<CharactersEntity>

    @Query("SELECT * FROM characters WHERE manga_id=:id")
    fun getCharactersByMangaID(id: Long): List<CharactersEntity>

    @Insert(onConflict = REPLACE)
    fun addCharacter(characterEntity: CharactersEntity)

    @Insert(onConflict = REPLACE)
    fun addUser(userEntity: UserEntity)
}
