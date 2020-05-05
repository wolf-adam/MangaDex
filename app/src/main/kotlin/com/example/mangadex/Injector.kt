package com.example.mangadex

import android.app.Activity

val Activity.chapterInjector: MainApplicationComponent
    get() {
        return (this.applicationContext as MainApplication).injector
    }

val Activity.mainInjector: MainApplicationComponent
    get() {
        return (this.applicationContext as MainApplication).injector
    }