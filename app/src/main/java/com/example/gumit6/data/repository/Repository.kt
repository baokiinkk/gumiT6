package com.example.gumit6.data.repository

import com.example.gumit6.data.db.model.Category
import com.example.gumit6.data.db.model.Movie

interface Repository{
   suspend fun getAllDataCategory(get: (MutableList<Category>) -> Unit)
   suspend fun addCategory(category: Category)

   suspend fun getAllDataMovie(get: (MutableList<Movie>) -> Unit)
   suspend fun getDataMovieByIdCategory(idCategory: String,get: (MutableList<Movie>) -> Unit)
   suspend fun getDataMovieByIdCaAndKeyword(idCategory: String,key:String,get: (MutableList<Movie>) -> Unit)

   suspend fun addMovie(movie: Movie)
}