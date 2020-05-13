package com.example.mangadex.model

import com.google.gson.annotations.SerializedName

data class Manga(
    @SerializedName("mal_id")
    var mal_id: Int? = null,

    @SerializedName("title")
    var title: String? = null,

    @SerializedName("url")
    var url: String? = null,

    @SerializedName("image_url")
    var image_url: String? = null,

    @SerializedName("type")
    var type: String? = null,

    @SerializedName("reading_status")
    var reading_status: Int? = null,

    @SerializedName("score")
    var score: Int? = null,

    @SerializedName("read_chapters")
    var read_chapters: Int? = null,

    @SerializedName("read_volumes")
    var read_volumes: Int? = null,

    @SerializedName("total_chapters")
    var total_chapters: Int? = null,

    @SerializedName("total_volumes")
    var total_volumes: Int? = null,

    @SerializedName("publishing_status")
    var publishing_status: Int? = null,

    @SerializedName("is_rereading")
    var is_rereading: Boolean? = null,

    @SerializedName("tags")
    var tags: String? = null,

    @SerializedName("start_date")
    var start_date: Int? = null,

    @SerializedName("end_date")
    var end_date: Int? = null,

    @SerializedName("read_start_date")
    var read_start_date: Int? = null,

    @SerializedName("read_end_date")
    var read_end_date: Int? = null,

    @SerializedName("days")
    var days: Int? = null,

    @SerializedName("retail")
    var retail: String? = null,

    @SerializedName("priority")
    var priority: String? = null,

    @SerializedName("added_to_list")
    var added_to_list: Boolean? = null,

    @SerializedName("magazines")
    var magazines:  MutableList<String>? = null
)
