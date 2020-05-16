package com.example.mangadex.model

import com.google.gson.annotations.SerializedName

data class MangaRequest(
    @SerializedName("request_hash")
    var request_hash: String? = null,

    @SerializedName("request_cached")
    var request_cached: Boolean? = null,

    @SerializedName("request_cache_expiry")
    var request_cache_expiry: Long? = null,

    @SerializedName("characters")
    var manga: List<Manga>? = null
)