package com.carbit3333333.cocktail_db.repository.server

import android.util.Log
import com.carbit3333333.cocktail_db.pojo.Categories
import com.carbit3333333.cocktail_db.pojo.Drink
import com.carbit3333333.cocktail_db.pojo.ListCategories
import com.carbit3333333.cocktail_db.pojo.ListDrinks
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.annotations.NonNull
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.ObservableTransformer
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.core.SingleTransformer
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class ServerCommunicator(private val mService: CocktailApi) {
    var listCategories: List<Categories>?= null
    var listDrinrs: List<Drink>?= null
    companion object{
        private val DEFAULT_TIMEOUT = 10
        private val DEFAULT_RETRY_ATTEMPTS = 4L
    }

    fun getResponseCategories(): @NonNull Observable<ListCategories>? {
       return mService.getCategories().compose(singleTransformer())
    }

    fun getListResponseCategory(strCategories: String) : @NonNull Observable<ListDrinks>? {
      return mService.getListCocktail(strCategories).compose(singleTransformer())

    }

    fun <T> singleTransformer(): ObservableTransformer<T, T> = ObservableTransformer {
        it.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .timeout(DEFAULT_TIMEOUT.toLong(), TimeUnit.SECONDS)
            .retry(DEFAULT_RETRY_ATTEMPTS)
    }
}