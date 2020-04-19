package com.example.mangadex

import android.app.Application
import com.example.mangadex.ui.UIModule

class MainApplication : Application() {
    lateinit var injector: MainApplicationComponent

    override fun onCreate() {
        super.onCreate()
        injector = DaggerMainApplicationComponent.builder().uIModule(UIModule(this)).build()
    }
}
