package com.carbit3333333.cocktail_db

import android.os.Bundle
import android.util.Log
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.carbit3333333.cocktail_db.adapters.AdapterCoctail
import com.carbit3333333.cocktail_db.di.App
import com.carbit3333333.cocktail_db.domain.CocktailViewModel
import com.carbit3333333.cocktail_db.pojo.Categories
import com.carbit3333333.cocktail_db.pojo.ListDrinks
import goldzweigapps.com.annotations.annotations.GencyclerModel
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    var viewModel: CocktailViewModel? = null
        @Inject set
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       var list: MutableList<ListDrinks> = ArrayList()
        createDaggerDependency()
        var adapter = AdapterCoctail(this)
        rvCoinPriceList.adapter = adapter
        viewModel?.getLiveDataItems()
            ?.observe(this, Observer {
                adapter.elements = it as MutableList<GencyclerModel>
                adapter.notifyDataSetChanged()
                Log.e("ListDrinksViewHolder", it.toString())

            })

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.filter_main, menu)
        return true
    }

    private fun createDaggerDependency() {
        (application as App).getViewModelComponent().inject(this)
    }
}
