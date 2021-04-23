package com.example.gumit6.data.usecase

import com.example.gumit6.data.db.model.Category
import com.example.gumit6.data.db.model.Movie
import com.example.gumit6.data.repository.Repository

class MovieUseCaseImpl(override val repo: Repository) : MovieUseCase {

    override suspend fun getMovie(idCategory:String,key:String?,getdata: (MutableList<Movie>) -> Unit) {
        if(idCategory == "Choose Category" && key == null)
            repo.getAllDataMovie {
                getdata(it)
            }
        else if(idCategory != "Choose Category" && key == null){
            repo.getDataMovieByIdCategory(idCategory){
                getdata(it)
            }
        }
        else if(idCategory != "Choose Category" && key != null){
            repo.getDataMovieByIdCaAndKeyword(idCategory,key){
                getdata(it)
            }
        }
    }

    override suspend fun getAllDataCategory(get: (List<String>) -> Unit) {
        repo.getAllDataCategory {
            it.add(0,Category("Choose Category"))
            get(it.map { data->data.categories })
        }


    }
}