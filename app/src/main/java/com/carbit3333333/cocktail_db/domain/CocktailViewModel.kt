package com.carbit3333333.cocktail_db.domain

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import com.carbit3333333.cocktail_db.pojo.Categories
import com.carbit3333333.cocktail_db.pojo.Drink
import com.carbit3333333.cocktail_db.pojo.ListCategories
import com.carbit3333333.cocktail_db.pojo.ListDrinks
import com.carbit3333333.cocktail_db.presentation.widget.SingleLiveIvent
import com.carbit3333333.cocktail_db.repository.server.ServerCommunicator
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

class CocktailViewModel(application: Application, private val serverCommunicator: ServerCommunicator
) :
    BaseViewModel(application) {
    var list = listOf<Any>()
    private var liveDataItems = SingleLiveIvent<List<Any>>()

    fun getLiveDataItems(): SingleLiveIvent<List<Any>> {
        return liveDataItems
    }
    fun getListCocktailCategories(){
        serverCommunicator.getResponseCategories()?.map{
            it.drinks
        }?.flatMap {
            it -> Observable.fromIterable(it)
        }?.flatMap {
           cat-> serverCommunicator.getListResponseCategory(cat.strCategory)?.map {dr->
            listOf(cat.strCategory, dr.drinks)
        }
        }?.subscribe { it ->

            list = it
        }
    }
}