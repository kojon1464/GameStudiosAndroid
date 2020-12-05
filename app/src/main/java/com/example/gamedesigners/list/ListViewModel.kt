package com.example.gamedesigners.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gamedesigners.data.DesignerEntry
import com.example.gamedesigners.data.Designers
import com.example.gamedesigners.data.StudioSize
import com.example.gamedesigners.data.favourite.Favourite
import com.example.gamedesigners.data.favourite.FavouriteEntry

class ListViewModel: ViewModel() {

    private val _designers = Designers().designers
    private var isFavouriteFilter = false

    private var _filteredDesigners = MutableLiveData<MutableList<DesignerEntry>>()
    val filteredDesigners: LiveData<MutableList<DesignerEntry>>
        get() = _filteredDesigners

    private var _favourites = MutableLiveData<MutableMap<Int, FavouriteEntry>>()
    val favourites: LiveData<MutableMap<Int, FavouriteEntry>>
        get() = _favourites

    private var _positionRemoved = MutableLiveData<Int>()
    val positionRemoved: LiveData<Int>
        get() = _positionRemoved

    init {
        _filteredDesigners.value = ArrayList(_designers)
        _favourites.value = Favourite.getFavouriteMap()
    }

    fun onFavouriteClick(id: Int){
        val entry = _favourites.value?.getOrElse(id) {FavouriteEntry(id, false)}
        _favourites.value?.set(id, FavouriteEntry(id, !entry?.favourite!!))
        Favourite.saveFavouriteMap(_favourites.value!!)
        if(isFavouriteFilter)
            filterFavourite()
        else
            _favourites.notifyObserver()
    }

    fun onDesignerRemove(position: Int) {
        val designer = _filteredDesigners.value?.removeAt(position)
        _designers.remove(designer)
        _positionRemoved.value = position
    }

    fun filterAll() {
        filter { true }
    }

    fun filterFavourite() {
        filter { designer ->
            val entry = _favourites.value?.getOrElse(designer.id) {FavouriteEntry(designer.id, false)}
             entry!!.favourite }
        isFavouriteFilter = true
    }

    fun filterIndie() {
        filter { it.sizeId == StudioSize.INDIE.resourceId }
    }

    fun filterSmall() {
        filter { it.sizeId == StudioSize.MEDIUM.resourceId }
    }

    fun filterAAA() {
        filter { it.sizeId == StudioSize.AAA.resourceId }
    }

    private fun filter(f:(DesignerEntry)->Boolean) {
        isFavouriteFilter = false
        _filteredDesigners.value?.clear()
        for (designer in _designers){
            if(f(designer))
                _filteredDesigners.value?.add(designer)
        }
        _filteredDesigners.notifyObserver()
    }
}

fun <T> MutableLiveData<T>.notifyObserver() {
    this.value = this.value
}