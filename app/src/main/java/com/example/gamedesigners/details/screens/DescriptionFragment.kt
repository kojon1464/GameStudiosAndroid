package com.example.gamedesigners.details.screens

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.gamedesigners.R
import com.example.gamedesigners.data.details.DesignersDetails
import com.example.gamedesigners.databinding.FragmentDescriptionBinding

private const val ARG_ID = "id"

class DescriptionFragment : Fragment() {

    private lateinit var binding: FragmentDescriptionBinding

    private var id: Int? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            id = it.getInt(ARG_ID)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_description, container, false)
        binding.descriptionTV.text = DesignersDetails().descriptions[id!!-1].description
        binding.descriptionTV.movementMethod = ScrollingMovementMethod()
        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance(id: Int) =
            DescriptionFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_ID, id)
                }
            }
    }
}