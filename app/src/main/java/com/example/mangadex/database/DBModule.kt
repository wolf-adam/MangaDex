package com.example.mangadex.database

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DBModule {
    companion object {
        private const val DB_NAME = "mangadex-db"
    }

    @Provides
    @Singleton
    fun provideMangaDatabase(context: Context): MangaDatabase {
        return Room.databaseBuilder(context, MangaDatabase::class.java, DB_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideMangaDao(mangaDatabase: MangaDatabase): MangaDao = mangaDatabase.mangaDao()
}