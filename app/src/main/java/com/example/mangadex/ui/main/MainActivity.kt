package com.example.mangadex.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mangadex.R

class MainActivity : AppCompatActivity(), MainScreen {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        MainPresenter.attachScreen(this)
    }

    override fun onStop() {
        super.onStop()
        MainPresenter.detachScreen()
    }

    override fun updateMainList() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}