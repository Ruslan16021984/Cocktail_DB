package com.carbit3333333.cocktail_db.domain

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.carbit3333333.cocktail_db.pojo.Categories
import com.carbit3333333.cocktail_db.pojo.Cell
import com.carbit3333333.cocktail_db.pojo.Drink
import com.carbit3333333.cocktail_db.pojo.ListCategories
import com.carbit3333333.cocktail_db.repository.server.ServerCommunicator
import io.reactivex.rxjava3.core.Observable

class CocktailViewModel(
    application: Application, private val serverCommunicator: ServerCommunicator
) :
    BaseViewModel(application) {

    init {
        getListCocktailCategories()
        getResponceForFilter()
    }

    private var liveDataItems = MutableLiveData<List<Cell>>()
    private var liveDataCategories = MutableLiveData<List<Categories>>()
    fun getLiveDataCategories(): MutableLiveData<List<Categories>> {
        return liveDataCategories
    }


    fun getLiveDataItems(): MutableLiveData<List<Cell>> {
        return liveDataItems
    }

    fun getListCocktailCategories() {
        serverCommunicator.getResponseCategories()?.map {
            it.drinks
        }?.flatMap { it ->
            Observable.fromIterable(it)
        }?.flatMap { cat ->
            serverCommunicator.getListResponseCategory(cat.strCategory)?.map { dr ->
                dr.drinks.flatMap { rdi ->
                    mutableSetOf(cat, rdi)
                }
            }
        }?.subscribe {
            var result = it.distinctBy {
                when (it) {
                    is Categories -> {
                        it.strCategory
                    }
                    is Drink -> {
                        it.strDrink
                    }
                    else -> throw IllegalArgumentException("unknown view type $it") as Throwable
                }
            }
            liveDataItems.value = result
        }
    }

    fun getResponceForFilter() {
        var listCategories: ListCategories? = null
        serverCommunicator.getResponseCategories()?.map {
            it.drinks
        }?.subscribe {
            liveDataCategories.value = it
        }
    }
}