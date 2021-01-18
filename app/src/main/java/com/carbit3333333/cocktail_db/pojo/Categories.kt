package com.carbit3333333.cocktail_db.pojo

import com.carbit3333333.cocktail_db.R
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import goldzweigapps.com.annotations.annotations.Filterable
import goldzweigapps.com.annotations.annotations.GencyclerModel
import goldzweigapps.com.annotations.annotations.GencyclerViewHolder

@GencyclerViewHolder(R.layout.layout_header_item)
@Filterable
data class Categories(
    @SerializedName("strCategory")
    @Expose
    val strCategory:String,
    var check: Boolean = false
): GencyclerModel