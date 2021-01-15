package com.carbit3333333.cocktail_db.adapters

import android.content.Context
import android.util.Log
import com.carbit3333333.cocktail_db.pojo.Categories
import com.carbit3333333.cocktail_db.pojo.Drink
import com.carbit3333333.cocktail_db.pojo.ListDrinks
import com.squareup.picasso.Picasso
import goldzweigapps.com.annotations.annotations.GencyclerAdapter
import goldzweigapps.com.gencycler.CategoriesViewHolder
import goldzweigapps.com.gencycler.DrinkViewHolder
import goldzweigapps.com.gencycler.ListDrinksViewHolder

@GencyclerAdapter(Categories::class, Drink::class)
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
//    var list: List<Any> = listOf()
//        set(value) {
//            field = value
//            notifyDataSetChanged()
//        }
//    override fun onBindCategoriesViewHolder(
//        categoriesViewHolder: CategoriesViewHolder,
//        categories: Categories,
//        position: Int
//    ) {
//        categoriesViewHolder.textHeader.text = categories.strCategory
////        Log.e("CategoriesViewHolder", elements.toString())
//    }
//
//    override fun onBindListDrinksViewHolder(
//        listDrinksViewHolder: ListDrinksViewHolder,
//        listDrinks: ListDrinks,
//        position: Int
//    ) {
//        listDrinksViewHolder.txCocktailName.text = listDrinks.drinks.get(position).strDrink
//        Picasso.get().load(listDrinks.drinks.get(position).getFullImageUrl()).into(listDrinksViewHolder.ivlogococktail)
////        Log.e("ListDrinksViewHolder", listDrinks.drinks.get(position).strDrink)
//    }


}