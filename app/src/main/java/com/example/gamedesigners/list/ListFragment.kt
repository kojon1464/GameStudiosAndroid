package com.example.gamedesigners.list

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.gamedesigners.R
import com.example.gamedesigners.databinding.FragmentListBinding


class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding

    private lateinit var viewModel: ListViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_list, container, false)
        viewModel = ViewModelProvider(this).get(ListViewModel::class.java)

        val adapter = DesignersAdapter(viewModel.filteredDesigners.value!!, viewModel.favourites.value!!, this)

        binding.apply {
            designersRV.adapter = adapter
        }

        val itemTouchHelper = ItemTouchHelper(SwipeController())
        itemTouchHelper.attachToRecyclerView(binding.designersRV)

        viewModel.positionRemoved.observe(viewLifecycleOwner, Observer {
            adapter.notifyItemRemoved(it)
        })

        viewModel.filteredDesigners.observe(viewLifecycleOwner, Observer {
            adapter.notifyDataSetChanged()
        })

        viewModel.favourites.observe(viewLifecycleOwner, Observer {
            adapter.notifyDataSetChanged()
        })

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_filter, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        item.isChecked = true
        when(item.itemId){
            R.id.all -> viewModel.filterAll()
            R.id.favourite -> viewModel.filterFavourite()
            R.id.indie -> viewModel.filterIndie()
            R.id.small -> viewModel.filterSmall()
            R.id.aaa -> viewModel.filterAAA()
        }
        return super.onOptionsItemSelected(item)
    }

    fun onFavouriteClick(id: Int) {
        viewModel.onFavouriteClick(id)
    }

    fun onItemClick(id: Int) {
        val action = ListFragmentDirections.actionListFragmentToDetailsFragment(id)
        NavHostFragment.findNavController(this).navigate(action)
    }

    inner class SwipeController : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {
        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder
        ): Boolean {
            return false
        }

        override fun onSwiped(holder: RecyclerView.ViewHolder, direction: Int) {
            val position = holder.adapterPosition
            viewModel.onDesignerRemove(position)
        }

    }
}