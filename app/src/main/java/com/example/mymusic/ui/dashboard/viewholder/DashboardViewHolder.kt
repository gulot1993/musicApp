package com.example.mymusic.ui.dashboard.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.mymusic.R
import com.example.mymusic.model.Music
import kotlinx.android.synthetic.main.item_music.view.*

class DashboardViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    fun bind(data: Music) {
        with(itemView) {
            sdvMusic.setImageURI(data.imageURL)
            tvTrackName.text = if (data.name != "") {
                data.name
            } else {
                context.getString(R.string.tv_no_trackname)
            }

            tvGenre.text = if (data.genre != "") {
                data.genre
            } else {
                context.getString(R.string.tv_no_genre)
            }

            tvPrice.text = "$${data.price}"

            tvDescription.text = if (data.description != "") {
                data.description
            } else {
                context.getString(R.string.tv_no_description)
            }
        }
    }
}