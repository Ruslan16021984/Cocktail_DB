package com.carbit3333333.cocktail_db.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Categories(
    @SerializedName("strCategory")
    @Expose
    val strCategory:String,
    var check: Boolean = false
): Cell()