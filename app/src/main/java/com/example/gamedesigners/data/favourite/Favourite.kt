package com.example.gamedesigners.data.favourite

import android.content.Context
import com.example.gamedesigners.App
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object Favourite {

    private const val PREFERENCES = "favourite"
    private const val KEY = "favourite"

    fun getFavouriteMap(): MutableMap<Int, FavouriteEntry> {
        val sharedPreferences = App.getContext().getSharedPreferences(PREFERENCES, Context.MODE_PRIVATE)

        val listString = sharedPreferences.getString(KEY, null)
        val gson = Gson()
        val favourite: MutableMap<Int, FavouriteEntry>

        favourite = if(listString == null) {
            HashMap()
        } else {
            val type = object : TypeToken<MutableMap<Int, FavouriteEntry>>() {}.type
            gson.fromJson<MutableMap<Int, FavouriteEntry>>(listString, type)
        }

        return favourite
    }

//    fun getFavourite(id: Int): FavouriteEntry {
//        return getFavouriteMap().getOrElse(id) {FavouriteEntry(id, false)}
//    }

    fun saveFavouriteMap(favourite: MutableMap<Int, FavouriteEntry>) {
        val gson = Gson()
        val sharedPreferences = App.getContext().getSharedPreferences(PREFERENCES, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString(KEY, gson.toJson(favourite))
        editor.apply()
    }
//
//    fun saveFavourite(id: Int, favourite: Boolean) {
//        val list = getFavouriteMap()
//        list[id] = FavouriteEntry(id, favourite)
//        saveFavouriteMap(list)
//    }
}