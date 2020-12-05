package com.example.gamedesigners.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.gamedesigners.R
import com.example.gamedesigners.databinding.FragmentDetailsBinding
import com.example.gamedesigners.details.screens.DescriptionFragment
import com.example.gamedesigners.details.screens.GalleryFragment
import com.example.gamedesigners.details.screens.GamesFragment
import com.google.android.material.tabs.TabLayoutMediator
import java.lang.UnsupportedOperationException

class DetailsFragment : Fragment() {

    private lateinit var binding: FragmentDetailsBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_details, container, false)
        val id = DetailsFragmentArgs.fromBundle(requireArguments()).id
        binding.pagerVP2.adapter = FragmentAdapter(createFragmentsList(id), this)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val tabLayout = binding.tabsTL
        TabLayoutMediator(tabLayout, binding.pagerVP2) { tab, position ->
            tab.text = when(position) {
                0 -> getString(R.string.description)
                1 -> getString(R.string.games)
                2 -> getString(R.string.gallery)
                else -> throw UnsupportedOperationException()
            }
        }.attach()
    }

    private fun createFragmentsList(id: Int): List<Fragment> {
        val list = ArrayList<Fragment>()
        list.add(DescriptionFragment.newInstance(id))
        list.add(GamesFragment.newInstance(id))
        list.add(GalleryFragment.newInstance(id))
        return list
    }

}