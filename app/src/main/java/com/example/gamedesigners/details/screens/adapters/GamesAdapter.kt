package com.example.gamedesigners.details.screens.adapters

import com.example.gamedesigners.databinding.ItemGameBinding

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


class GamesAdapter(private val games: List<String>) : RecyclerView.Adapter<GamesAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemGameBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val itemBinding = ItemGameBinding.inflate(inflater, parent, false)
        return ViewHolder(itemBinding)
    }

    override fun getItemCount(): Int {
        return games.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val game = games[position]

        holder.binding.apply {
            gameTV.text = game
        }
    }
}