package com.example.gumit6.ui.movies

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gumit6.data.db.model.Category
import com.example.gumit6.data.db.model.Movie
import com.example.gumit6.data.repository.Repository
import com.example.gumit6.data.usecase.MovieUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieViewmodel(val data:MovieUseCase) :ViewModel(){
    val dataCategory:MutableLiveData<List<String>?> = MutableLiveData(null)
    val dataMovie:MutableLiveData<MutableList<Movie>?> = MutableLiveData(null)
    val keyword:MutableLiveData<String?> = MutableLiveData(null)
    val isClick:MutableLiveData<Boolean?> = MutableLiveData(null)
    fun getCategory(){
        viewModelScope.launch(Dispatchers.IO) {
            data.getAllDataCategory {
                dataCategory.postValue(it)
            }
        }
    }
    fun getMovie(idCategory: String,key:String?=null){
        viewModelScope.launch(Dispatchers.IO){
            data.getMovie(idCategory,key){
                dataMovie.postValue(it)
            }
        }
    }
    fun onClick(v: View){
        isClick.postValue(true)
    }
}