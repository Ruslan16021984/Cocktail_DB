package com.carbit3333333.cocktail_db.pojo

import com.carbit3333333.cocktail_db.R
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import goldzweigapps.com.annotations.annotations.GencyclerModel
import goldzweigapps.com.annotations.annotations.GencyclerViewHolder

data class ListDrinks (
    @SerializedName("drinks")
    @Expose
    val  drinks: List<Drink>
)