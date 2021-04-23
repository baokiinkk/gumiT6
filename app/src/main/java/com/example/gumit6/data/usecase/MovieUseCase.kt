package com.example.gumit6.data.usecase

import com.example.gumit6.data.db.model.Category
import com.example.gumit6.data.db.model.Movie
import com.example.gumit6.data.repository.Repository

interface MovieUseCase {
    val repo : Repository
    suspend fun getMovie(idCategory:String,key:String?,getdata:(MutableList<Movie>) -> Unit)
    suspend fun getAllDataCategory(get: (List<String>) -> Unit)

}