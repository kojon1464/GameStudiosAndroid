package com.example.gamedesigners.details.screens.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gamedesigners.databinding.ItemPictureBinding


class GalleryAdapter(private val images: List<Int>) : RecyclerView.Adapter<GalleryAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemPictureBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val itemBinding = ItemPictureBinding.inflate(inflater, parent, false)
        return ViewHolder(itemBinding)
    }

    override fun getItemCount(): Int {
        return images.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val image = images[position]

        holder.binding.apply {
            pictureIV.setImageResource(image)
        }
    }
}