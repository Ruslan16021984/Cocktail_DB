package com.carbit3333333.cocktail_db.di.component

import com.carbit3333333.cocktail_db.di.module.ApiModule
import com.carbit3333333.cocktail_db.repository.server.ServerCommunicator
import dagger.Component
import javax.inject.Singleton

@Component(modules = [ApiModule::class])
@Singleton
interface AppComponent {
    val serverCommunicator: ServerCommunicator
}