package com.example.mangadex.model

import com.google.gson.annotations.SerializedName

data class MangaResult(
    @SerializedName("mal_id")
    var mal_id: Int? = null,

    @SerializedName("title")
    var title: String? = null,

    @SerializedName("url")
    var url: String? = null,

    @SerializedName("image_url")
    var image_url: String? = null,

    @SerializedName("score_Num")
    var score_Num: Int? = null,

    @SerializedName("total_chapter")
    var total_chapter: Int? = null
)
