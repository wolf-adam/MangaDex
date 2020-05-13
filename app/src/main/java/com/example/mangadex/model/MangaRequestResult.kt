package com.example.mangadex.model

import com.google.gson.annotations.SerializedName

data class MangaRequestResult(
    @SerializedName("manga_request")
    var manga_request: MangaRequest? = null
)
