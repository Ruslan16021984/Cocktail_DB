package com.carbit3333333.cocktail_db.adapters

import android.content.Context
import android.util.Log
import android.view.ViewGroup
import com.carbit3333333.cocktail_db.pojo.Categories
import com.carbit3333333.cocktail_db.pojo.Drink
import goldzweigapps.com.annotations.annotations.GencyclerAdapter
import goldzweigapps.com.gencycler.CategoriesViewHolder
import goldzweigapps.com.gencycler.DrinkViewHolder
import goldzweigapps.com.gencycler.GencyclerHolder

@GencyclerAdapter(Categories::class, Drink::class)
class AdapterCoctail(context: Context) : GeneratedAdapterCoctail(context) {

    override fun onBindCategoriesViewHolder(
        categoriesViewHolder: CategoriesViewHolder,
        categories: Categories,
        position: Int
    ) {
        categoriesViewHolder.textHeader
        Log.e("AdapterCoctail", categories.strCategory)
    }

    override fun onBindDrinkViewHolder(
        drinkViewHolder: DrinkViewHolder,
        drink: Drink,
        position: Int
    ) {
        Log.e("onBindDrinkViewHolder", drink.strDrink)
    }


}