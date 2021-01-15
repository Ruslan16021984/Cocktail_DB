package com.carbit3333333.cocktail_db.adapters

import android.content.Context
import android.util.Log
import com.carbit3333333.cocktail_db.pojo.Categories
import com.carbit3333333.cocktail_db.pojo.Drink
import com.carbit3333333.cocktail_db.pojo.ListDrinks
import com.squareup.picasso.Picasso
import goldzweigapps.com.annotations.annotations.Filterable
import goldzweigapps.com.annotations.annotations.GencyclerAdapter
import goldzweigapps.com.annotations.annotations.GencyclerModel
import goldzweigapps.com.gencycler.CategoriesViewHolder
import goldzweigapps.com.gencycler.DrinkViewHolder

@GencyclerAdapter(Categories::class, Drink::class)
@Filterable
class AdapterCoctail(context: Context): GeneratedAdapterCoctail(context){
    override fun onBindCategoriesViewHolder(
        categoriesViewHolder: CategoriesViewHolder,
        categories: Categories,
        position: Int
    ) {
        categoriesViewHolder.textHeader.text = categories.strCategory
    }

    override fun onBindDrinkViewHolder(
        drinkViewHolder: DrinkViewHolder,
        drink: Drink,
        position: Int
    ) {
        drinkViewHolder.txCocktailName.text = drink.strDrink
        Picasso.get().load(drink.getFullImageUrl()).into(drinkViewHolder.ivlogococktail)
    }

    override fun performFilter(constraint: CharSequence, gencyclerModel: GencyclerModel): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}