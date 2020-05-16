package com.example.mangadex.model

import com.google.gson.annotations.SerializedName

data class MangaRequestResult(
    @SerializedName("id")
    var id: Long? = null,

    @SerializedName("manga_request")
    var manga_request: MangaRequest? = null
)
