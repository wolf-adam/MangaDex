package com.example.mangadex.ui.character

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mangadex.R
import com.example.mangadex.model.Character
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.character_element.view.*

class CharacterAdapter constructor(
    private val context: Context,
    private val listener: Listener) : ListAdapter<Character, CharacterAdapter.ViewHolder>(CharacterComparator()) {

    interface Listener {
        fun onItemClicked(mal_id: Long)
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var card: CardView = view.char_CV
        var manga_img: ImageView = view.char_IV
        var name: TextView = view.char_name_TV
        var role: TextView = view.char_role_TV
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.character_element, viewGroup, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val character = getItem(position)

        holder.name.text = character.name

        Picasso.with(context).load(character.image_url)
            .placeholder(R.drawable.ic_launcher_background)
            .into(holder.manga_img)

        holder.role.text = character.role

        holder.card.setOnClickListener {
            character.mal_id?.let {
                listener.onItemClicked(it)
            }
        }
    }
}