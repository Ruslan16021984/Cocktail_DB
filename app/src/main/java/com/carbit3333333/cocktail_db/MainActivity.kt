package com.carbit3333333.cocktail_db

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.carbit3333333.cocktail_db.di.App
import com.carbit3333333.cocktail_db.domain.CocktailViewModel
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
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
