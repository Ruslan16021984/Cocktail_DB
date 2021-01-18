package com.carbit3333333.cocktail_db.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.carbit3333333.cocktail_db.R
import com.carbit3333333.cocktail_db.pojo.Categories
import kotlinx.android.synthetic.main.layout_item_filter.view.*
import kotlinx.android.synthetic.main.ltem_layout_button_filter.view.*

class FilterAdapter(var context: Context, val list: List<Categories>?) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var categoriesList = ArrayList<Categories>()



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            R.layout.layout_item_filter -> {
                val v = inflater
                    .inflate(R.layout.layout_item_filter, parent, false)
                FilterHolder(v)
            }
            R.layout.ltem_layout_button_filter -> {
                val v = inflater
                    .inflate(R.layout.ltem_layout_button_filter, parent, false)
                FilterButtonHolder(v)
            }
            else -> throw IllegalArgumentException("unknown view type $viewType")
        }


    }

    override fun getItemCount(): Int {
        return list?.size!!+1
    }


    override fun getItemViewType(position: Int): Int {
        Log.e("getItemViewType", "list size $position")
        return when (position) {
            list?.size -> R.layout.ltem_layout_button_filter
            else -> R.layout.layout_item_filter
        }
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(getItemViewType(position)){
            R.layout.layout_item_filter -> {
                (holder as FilterHolder).myCheckBox.isSelected = this.list?.get(position)?.check!!
                holder.tvName.text = this.list[position].strCategory
                holder.setOnClickListener(object : FilterHolder.ItemClickListener {
                    override fun onItemClick(v: View, pos: Int) {
                        val myCheckBox = v as CheckBox
                        val currentCategory = list[pos]
                        if (myCheckBox.isChecked) {
                            currentCategory.check = true
                            categoriesList.add(currentCategory)
                        } else if (!myCheckBox.isChecked) {
                            currentCategory.check = false
                            categoriesList.remove(currentCategory)
                        }

                    }

                })
            }
            R.layout.ltem_layout_button_filter ->{
                (holder as FilterButtonHolder).bind()
            }
        }

    }
    class FilterHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        var myCheckBox: CheckBox = itemView.checkboxFilter
        var tvName: TextView = itemView.tvCategory


        lateinit var myItemClicklistener: ItemClickListener

        override fun onClick(v: View) {
            this.myItemClicklistener.onItemClick(v, layoutPosition)
        }

        init {
            myCheckBox = itemView.checkboxFilter
            myCheckBox.setOnClickListener(this)
        }

        fun setOnClickListener(ic: ItemClickListener) {
            this.myItemClicklistener = ic
        }

        interface ItemClickListener {
            fun onItemClick(v: View, pos: Int)
        }

    }
    class FilterButtonHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var btnAply = itemView.btnApply
        fun bind(){
            btnAply.setOnClickListener {

            }
        }


    }
}