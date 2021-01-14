package com.carbit3333333.cocktail_db.adapters

import android.content.Context
import android.util.Log
import com.carbit3333333.cocktail_db.pojo.Categories
import com.carbit3333333.cocktail_db.pojo.Drink
import goldzweigapps.com.annotations.annotations.GencyclerAdapter
import goldzweigapps.com.gencycler.CategoriesViewHolder
import goldzweigapps.com.gencycler.DrinkViewHolder

@GencyclerAdapter(Categories::class, Drink::class)
class AdapterCoctail(context: Context) : GeneratedAdapterCoctail(context) {
    var coinInfoList: List<Any> = listOf()
        set(value) {
            Log.e("observe", value.toString())
            field = value
            notifyDataSetChanged()
        }
    override fun onBindCategoriesViewHolder(
        categoriesViewHolder: CategoriesViewHolder,
        categories: Categories,
        position: Int
    ) {

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