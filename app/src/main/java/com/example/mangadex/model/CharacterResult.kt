package com.example.mangadex.model

import com.google.gson.annotations.SerializedName

data class CharacterResult (
    @SerializedName("character_name")
    var character_name: String? = null,

    @SerializedName("character_url")
    var character_url: String? = null,

    @SerializedName("character_image_url")
    var chaacter_image_url: String? = null
)
