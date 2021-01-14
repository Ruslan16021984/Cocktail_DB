package com.carbit3333333.cocktail_db.di

import android.app.Application
import com.carbit3333333.cocktail_db.di.component.DaggerAppComponent
import com.carbit3333333.cocktail_db.di.component.DaggerViewModelComponent
import com.carbit3333333.cocktail_db.di.component.ViewModelComponent
import com.carbit3333333.cocktail_db.di.module.ApiModule
import com.carbit3333333.cocktail_db.di.module.ViewModuleModule

class App : Application() {

    private var viewModelComponent: ViewModelComponent? = null
    override fun onCreate() {
        super.onCreate()
        initDagger()
    }

    private fun initDagger() {
        DaggerAppComponent.builder().apiModule(ApiModule()).build()
        viewModelComponent = DaggerViewModelComponent.builder()
            .viewModuleModule(ViewModuleModule(this)).build()

    }
    fun getViewModelComponent(): ViewModelComponent{
        return this.viewModelComponent!!
    }


}