package com.example.gamedesigners.details.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.gamedesigners.R
import com.example.gamedesigners.data.details.DesignersDetails
import com.example.gamedesigners.databinding.FragmentGalleryBinding
import com.example.gamedesigners.details.screens.adapters.GalleryAdapter

private const val ARG_ID = "id"

class GalleryFragment : Fragment() {

    private lateinit var binding: FragmentGalleryBinding

    private var id: Int? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            id = it.getInt(ARG_ID)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_gallery, container, false)
        val adapter = GalleryAdapter(DesignersDetails().galleries[id!!-1].pictures)
        binding.galleryRV.adapter = adapter
        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance(id: Int) =
            GalleryFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_ID, id)
                }
            }
    }
}