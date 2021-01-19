package com.carbit3333333.cocktail_db.domain

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.carbit3333333.cocktail_db.pojo.Categories
import com.carbit3333333.cocktail_db.pojo.Cell
import com.carbit3333333.cocktail_db.pojo.ListCategories
import com.carbit3333333.cocktail_db.repository.server.ServerCommunicator
import goldzweigapps.com.annotations.annotations.GencyclerModel
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
    fun getLiveDataCategories():MutableLiveData<List<Categories>>{
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
                    mutableListOf(cat,rdi)
                }
            }
        }?.subscribe {
            liveDataItems.value = it
        }
    }
    fun getResponceForFilter() {
        var listCategories:ListCategories? = null
        serverCommunicator.getResponseCategories()?.map {it.drinks
        }?.subscribe {
            liveDataCategories.value = it
        }
    }
}