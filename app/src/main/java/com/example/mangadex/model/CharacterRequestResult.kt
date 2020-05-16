package com.example.mangadex.model

import com.google.gson.annotations.SerializedName

data class CharacterRequestResult(
    @SerializedName("id")
    var id: Long? = null,

    @SerializedName("character_request")
    var character_request: CharacterRequest? = null
)
