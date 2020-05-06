package com.example.mangadex

import com.example.mangadex.interactor.InteractorModule
import com.example.mangadex.ui.UIModule
import com.example.mangadex.database.DBModule
import com.example.mangadex.network.NetworkModule
import com.example.mangadex.ui.chapter.ChapterActivity
import com.example.mangadex.ui.main.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        NetworkModule::class,
        DBModule::class,
        UIModule::class,
        InteractorModule::class
    ]
)
interface MainApplicationComponent {
    fun inject(chapterActivity: ChapterActivity)
    fun inject(mainActivity: MainActivity)
}