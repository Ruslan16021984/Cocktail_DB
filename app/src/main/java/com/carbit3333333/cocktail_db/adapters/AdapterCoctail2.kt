package com.carbit3333333.cocktail_db.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import com.carbit3333333.cocktail_db.R
import com.carbit3333333.cocktail_db.pojo.Categories
import com.carbit3333333.cocktail_db.pojo.Cell
import com.carbit3333333.cocktail_db.pojo.Drink
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_cockteil_info.view.*
import kotlinx.android.synthetic.main.layout_header_item.view.*
import kotlinx.android.synthetic.main.layout_item_filter.view.*

class AdapterCoctail2(var items: ArrayList<Cell> = ArrayList()) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            Categories::class.java.name.hashCode() -> {
                CategoryViewHolder(parent.inflate(R.layout.layout_header_item))
            }
            Drink::class.java.name.hashCode() -> {
                CoctailViewHolder(parent.inflate(R.layout.item_cockteil_info))
            }
            else -> throw IllegalArgumentException("unknown view type $viewType")
        }
    }

    fun ViewGroup.inflate(@LayoutRes resId: Int) = LayoutInflater.from(this.context)
        .inflate(resId, this, false)

    override fun getItemCount(): Int {
       return items.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (val item = items[holder.adapterPosition]) {
            is Categories -> (holder as CategoryViewHolder).bind(item)
            is Drink -> (holder as CoctailViewHolder).bind(item)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return items[position].identifier()
    }

    class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name = itemView.text_header
        fun bind(cell: Cell) {
            name.text = (cell as Categories).strCategory
        }
    }

    class CoctailViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name =itemView.tx_cocktail_name
        var logo = itemView.ivLogoCocktail
        fun bind(cell: Cell) {
            name.text = (cell as Drink).strDrink
            logo = itemView.ivLogoCocktail
            Picasso.get().load((cell).getFullImageUrl()).into(logo)
        }
    }

}