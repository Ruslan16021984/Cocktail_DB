package com.carbit3333333.cocktail_db.di.module

import android.app.Application
import com.carbit3333333.cocktail_db.di.App
import com.carbit3333333.cocktail_db.domain.CocktailViewModel
import com.carbit3333333.cocktail_db.repository.server.ServerCommunicator
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [ApiModule::class])
class ViewModuleModule(app: App) {
    internal var app: Application = app

    @Provides
    @Singleton
    internal fun providesCocktailViewModel(serverCommunicator: ServerCommunicator): CocktailViewModel{
        return CocktailViewModel(app, serverCommunicator)
    }
}