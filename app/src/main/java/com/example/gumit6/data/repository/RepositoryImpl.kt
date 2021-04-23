package com.example.gumit6.data.repository
import android.util.Log
import com.example.gumit6.data.db.AppDao
import com.example.gumit6.data.db.model.Category
import com.example.gumit6.data.db.model.Movie
import java.lang.Exception


class RepositoryImpl(val data: AppDao):Repository{
    override suspend fun getAllDataCategory(get: (MutableList<Category>) -> Unit) {
            get(data.getCategory())
    }

    override suspend fun addCategory(category: Category) {
        data.addCategory(category)
    }

    override suspend fun getAllDataMovie(get: (MutableList<Movie>) -> Unit) {
        get(data.getMoviebyidCNull())
    }

    override suspend fun getDataMovieByIdCategory(
        idCategory: String,
        get: (MutableList<Movie>) -> Unit
    ) {
        get(data.getMoviebyIdCategory(idCategory))
    }

    override suspend fun getDataMovieByIdCaAndKeyword(
        idCategory: String,
        key: String,
        get: (MutableList<Movie>) -> Unit
    ) {
        get(data.getMoviebyIdCategoryAndKeyword(idCategory,key))
    }


    override suspend fun addMovie(movie: Movie) {
        data.addMovie(movie)
    }
}