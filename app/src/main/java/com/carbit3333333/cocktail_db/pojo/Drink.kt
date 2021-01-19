package com.carbit3333333.cocktail_db.pojo

import com.carbit3333333.cocktail_db.R
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import goldzweigapps.com.annotations.annotations.GencyclerModel
import goldzweigapps.com.annotations.annotations.GencyclerViewHolder

@GencyclerViewHolder(R.layout.item_cockteil_info)
data class Drink(
    @SerializedName("idDrink")
    @Expose
    val idDrink: Long,
    @SerializedName("strDrink")
    @Expose
    val strDrink: String,
    @SerializedName("strDrinkThumb")
    @Expose
    val  strDrinkThumb:String


): Cell() {
    fun getFullImageUrl(): String {
        return strDrinkThumb
    }
}
