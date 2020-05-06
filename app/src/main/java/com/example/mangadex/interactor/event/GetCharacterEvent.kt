package com.example.mangadex.interactor.event

import com.example.mangadex.model.CharacterResult

class GetCharacterEvent (
    var code: Int = 0,
    var character_name: String? = null,
    var character_url: String? = null,
    var chaacter_image_url: String? = null,
    var throwable: Throwable? = null
)
