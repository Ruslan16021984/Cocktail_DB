package com.carbit3333333.cocktail_db.pojo

open class Cell {
    fun identifier() = this::class.java.name.hashCode()
}