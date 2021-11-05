package com.example.mymusic.ui.dashboard.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mymusic.R
import com.example.mymusic.model.Music
import com.example.mymusic.ui.dashboard.viewholder.DashboardViewHolder

class DashboardAdapter(val context: Context): RecyclerView.Adapter<DashboardViewHolder>() {
    private val items = mutableListOf<Music>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashboardViewHolder {
        return DashboardViewHolder(LayoutInflater.from(context).inflate(R.layout.item_music, parent, false))
    }

    override fun onBindViewHolder(holder: DashboardViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = items.size

    fun setData(data: List<Music>) {
        items.clear()
        items.addAll(data)
        notifyDataSetChanged()
    }
}