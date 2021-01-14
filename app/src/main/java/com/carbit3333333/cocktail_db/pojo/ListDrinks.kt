package com.carbit3333333.cocktail_db.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ListDrinks (
    @SerializedName("drinks")
    @Expose
    val  drinks: List<Drink>
)