package com.carbit3333333.cocktail_db.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Drink(
    @SerializedName("idDrink")
    @Expose
    val idDrink: Long,
    @SerializedName("strDrink")
    @Expose
    val strDrink: String,
    @SerializedName("strDrinkThumb")
    @Expose
    val  strDrinkThumb:String,
    var strCategory: String


): Cell() {
    fun getFullImageUrl(): String {
        return strDrinkThumb
    }
}
