package com.carbit3333333.cocktail_db.repository.server

import com.carbit3333333.cocktail_db.pojo.ListCategories
import com.carbit3333333.cocktail_db.pojo.ListDrinks
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Query

interface CocktailApi {
    @GET("list.php")
    fun getCategories(@Query("c") param: String = "list"): Observable<ListCategories>

    @GET("filter.php")
    fun getListCocktail(@Query("c") name:String): Observable<ListDrinks>

}