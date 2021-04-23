package com.example.gumit6.ui.addmovie

import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gumit6.data.db.model.Category
import com.example.gumit6.data.db.model.Movie
import com.example.gumit6.data.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddMovieViewmodel(val data:Repository) :ViewModel(){
    val dataCategory:MutableLiveData<MutableList<Category>?> = MutableLiveData(null)
    val movieName:MutableLiveData<String?> = MutableLiveData(null)
    val isClick:MutableLiveData<Boolean?> = MutableLiveData(null)
    val isFinish:MutableLiveData<Boolean?> = MutableLiveData(null)
    fun getCategory(){
        viewModelScope.launch(Dispatchers.IO) {
            data.getAllDataCategory {
                dataCategory.postValue(it)
            }
        }
    }
    fun addMovie( idCategory: String){
        viewModelScope.launch(Dispatchers.IO) {
            movieName.value?.let {
                data.addMovie(Movie(0,it,idCategory))
            }
        }
    }
    fun getMovie(v:View){
        isFinish.postValue(true)
    }
    fun onClickAddMovie(v: View){
        isClick.postValue(true)
    }
}