package com.example.gumit6.data.usecase

import com.example.gumit6.data.db.model.Category
import com.example.gumit6.data.db.model.Movie
import com.example.gumit6.data.repository.Repository

class MovieUseCaseImpl(override val repo: Repository) : MovieUseCase {

    override suspend fun getMovie(idCategory:String,key:String,getdata: (List<String>) -> Unit) {
        if(idCategory == "Choose Category" && key == "")
            repo.getAllDataMovie {
                getdata(it.map { data->data.name })
            }
        else if(idCategory != "Choose Category" && key == ""){
            repo.getDataMovieByIdCategory(idCategory){
                getdata(it.map { data->data.name })
            }
        }
        else if(idCategory != "Choose Category" && key != ""){
            repo.getDataMovieByIdCaAndKeyword(idCategory,key){
                getdata(it.map { data->data.name })
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