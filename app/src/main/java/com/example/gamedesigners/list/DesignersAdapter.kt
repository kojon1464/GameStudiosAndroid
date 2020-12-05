package com.example.gamedesigners.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gamedesigners.App
import com.example.gamedesigners.data.DesignerEntry
import com.example.gamedesigners.data.favourite.FavouriteEntry
import com.example.gamedesigners.databinding.ItemDesignerBinding

class DesignersAdapter(private val designers: List<DesignerEntry>, private val favourites: Map<Int, FavouriteEntry>, private val handler: ListFragment) : RecyclerView.Adapter<DesignersAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemDesignerBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val itemBinding = ItemDesignerBinding.inflate(inflater, parent, false)
        return ViewHolder(itemBinding)
    }

    override fun getItemCount(): Int {
        return designers.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val context = App.getContext()
        val studio = designers[position]

        holder.binding.apply {
            root.setOnClickListener {handler.onItemClick(studio.id)}
            logoIV.setImageResource(studio.logoId)
            nameTV.text = studio.name
            sizeTV.text = context.getString(studio.sizeId)
            favouriteIV.imageAlpha = if (favourites.getOrElse(studio.id) {FavouriteEntry(studio.id, false)}.favourite)  255 else 50
            favouriteIV.setOnClickListener {handler.onFavouriteClick(studio.id)}
        }
    }
}