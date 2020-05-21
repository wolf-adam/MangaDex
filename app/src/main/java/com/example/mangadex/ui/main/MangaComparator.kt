package com.example.mangadex.ui.main

import androidx.recyclerview.widget.DiffUtil
import com.example.mangadex.model.Manga

class MangaComparator : DiffUtil.ItemCallback<Manga>() {
    override fun areItemsTheSame(oldItem: Manga, newItem: Manga): Boolean {
        return oldItem.mal_id == newItem.mal_id
    }

    override fun areContentsTheSame(oldItem: Manga, newItem: Manga): Boolean {
        return oldItem == newItem
    }
}
