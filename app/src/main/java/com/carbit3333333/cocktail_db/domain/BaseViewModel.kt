package com.carbit3333333.cocktail_db.domain

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.carbit3333333.cocktail_db.di.App

abstract class BaseViewModel (application: Application): AndroidViewModel(application){
    fun getContext() = getApplication<App>()
}