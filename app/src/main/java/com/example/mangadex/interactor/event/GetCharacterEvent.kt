package com.example.mangadex.interactor.event

import com.example.mangadex.model.Character

class GetCharacterEvent (
    var code: Int = 0,
    var characters: List<Character>? = null,
    var throwable: Throwable? = null
)
