package com.carbit3333333.cocktail_db.di.component

import com.carbit3333333.cocktail_db.MainActivity
import com.carbit3333333.cocktail_db.di.module.ViewModuleModule
import dagger.Component
import javax.inject.Singleton

@Component(modules = [ViewModuleModule::class])
@Singleton
interface ViewModelComponent {
    fun inject(activity:MainActivity)

}