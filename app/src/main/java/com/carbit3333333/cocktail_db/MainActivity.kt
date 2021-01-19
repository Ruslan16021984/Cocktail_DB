package com.carbit3333333.cocktail_db

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.carbit3333333.cocktail_db.di.App
import com.carbit3333333.cocktail_db.domain.CocktailViewModel
import com.carbit3333333.cocktail_db.pojo.Cell
import goldzweigapps.com.annotations.annotations.GencyclerModel
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    var list: MutableList<Cell> = ArrayList()
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
