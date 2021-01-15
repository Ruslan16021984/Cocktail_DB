package com.carbit3333333.cocktail_db.domain

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.carbit3333333.cocktail_db.repository.server.ServerCommunicator
import goldzweigapps.com.annotations.annotations.GencyclerModel
import io.reactivex.rxjava3.core.Observable

class CocktailViewModel(application: Application, private val serverCommunicator: ServerCommunicator
) :
    BaseViewModel(application) {

    init {
        getListCocktailCategories()
    }
    private var liveDataItems = MutableLiveData<List<GencyclerModel>>()

    fun getLiveDataItems(): MutableLiveData<List<GencyclerModel>> {
        return liveDataItems
    }
    fun getListCocktailCategories(){
        serverCommunicator.getResponseCategories()?.map{
            it.drinks
        }?.flatMap {
            it -> Observable.fromIterable(it)
        }?.flatMap {
           cat-> serverCommunicator.getListResponseCategory(cat.strCategory)?.map {dr->
            dr.drinks.flatMap { rdi ->
                mutableListOf(cat, rdi)
            }
        }
        }?.subscribe {
            liveDataItems.value = it
        }
    }
}