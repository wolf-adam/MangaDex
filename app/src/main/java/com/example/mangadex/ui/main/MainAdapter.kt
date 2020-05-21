package com.example.mangadex.ui.main

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
import com.example.mangadex.model.Manga
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.main_element.view.*

class MainAdapter constructor(
    private val context: Context,
    private val listener: Listener) : ListAdapter<Manga, MainAdapter.ViewHolder>(MangaComparator()) {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var card: CardView = view.main_CV
        var manga_img: ImageView = view.mainElement_IV
        var name: TextView = view.name_TV
        var chapter_number: TextView = view.chapter_num_TV
        var rating: TextView = view.rating_num_TV
    }

    interface Listener {
        fun onItemClicked(mal_id: Long)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.main_element, viewGroup, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val manga = getItem(position)

        holder.name.text = manga.title

        Picasso.with(context).load(manga.image_url)
            .placeholder(R.drawable.ic_launcher_background)
            .into(holder.manga_img)

        holder.rating.text = "${manga.score?.toString()} / 10"
        holder.chapter_number.text = "Total chapters: ${manga.total_chapters.toString()}"

        holder.card.setOnClickListener {
            manga.mal_id?.let {
                listener.onItemClicked(it)
            }
        }
    }
}
