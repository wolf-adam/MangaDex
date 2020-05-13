package com.example.mangadex.model

import com.google.gson.annotations.SerializedName

data class Character(
    @SerializedName("mal_id")
    var mal_id: Long? = null,

    @SerializedName("url")
    var url: String? = null,

    @SerializedName("image_url")
    var image_url: String? = null,

    @SerializedName("name")
    var name: String? = null,

    @SerializedName("role")
    var role: String? = null
)
