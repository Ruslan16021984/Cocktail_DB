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
    var list: MutableList<GencyclerModel> = ArrayList()
    var viewModel: CocktailViewModel? = null
        @Inject set

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        createDaggerDependency()
    }

    private fun createDaggerDependency() {
        (application as App).getViewModelComponent().inject(this)
    }
}
