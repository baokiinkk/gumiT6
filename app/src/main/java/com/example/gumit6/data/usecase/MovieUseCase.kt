package com.example.gumit6.data.usecase

import com.example.gumit6.data.repository.Repository

interface MovieUseCase {
    val repo : Repository
    suspend fun getMovie(idCategory:String,key:String?,getdata:(List<String>) -> Unit)
    suspend fun getAllDataCategory(get: (List<String>) -> Unit)

}