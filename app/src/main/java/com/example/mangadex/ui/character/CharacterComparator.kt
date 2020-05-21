package com.example.mangadex.ui.character

import androidx.recyclerview.widget.DiffUtil
import com.example.mangadex.model.Character

class CharacterComparator : DiffUtil.ItemCallback<Character>() {
    override fun areItemsTheSame(oldItem: Character, newItem: Character): Boolean {
        return oldItem.mal_id == newItem.mal_id
    }

    override fun areContentsTheSame(oldItem: Character, newItem: Character): Boolean {
        return oldItem == newItem
    }
}