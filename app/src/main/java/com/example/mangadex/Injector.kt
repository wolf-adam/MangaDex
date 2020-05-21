package com.example.mangadex

import android.app.Activity

val Activity.injector: MainApplicationComponent
    get() = (this.applicationContext as MainApplication).injector
