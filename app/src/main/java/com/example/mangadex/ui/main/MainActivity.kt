package com.example.mangadex.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mangadex.R
import com.example.mangadex.mainInjector
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainScreen {
    @Inject
    lateinit var mainPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainInjector.inject(this)
        mainPresenter.attachScreen(this)
    }

    override fun onStart() {
        super.onStart()
        mainPresenter.attachScreen(this)
    }

    override fun onStop() {
        super.onStop()
        mainPresenter.detachScreen()
    }

    override fun updateMainList() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}