package com.carbit3333333.cocktail_db

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.carbit3333333.cocktail_db.di.App
import com.carbit3333333.cocktail_db.domain.CocktailViewModel
import com.carbit3333333.cocktail_db.pojo.Cell
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    lateinit var navController: NavController
    var list: MutableList<Cell> = ArrayList()
    var viewModel: CocktailViewModel? = null
        @Inject set

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        navController = Navigation.findNavController(
//            this@MainActivity,
//            R.id.nav_host_fragment
//        )
//        NavigationUI.setupActionBarWithNavController(
//            (this),
//            navController
//        )
        createDaggerDependency()
    }

    private fun createDaggerDependency() {
        (application as App).getViewModelComponent().inject(this)
    }
}
