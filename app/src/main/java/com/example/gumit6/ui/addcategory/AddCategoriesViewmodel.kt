package com.example.gumit6.ui.addcategory

import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.*
import com.example.gumit6.data.db.model.Category
import com.example.gumit6.data.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddCategoriesViewmodel(val data:Repository) :ViewModel(){
    var category:MutableLiveData<String?> = MutableLiveData(null)
    val isonClick:MutableLiveData<Boolean?> = MutableLiveData(null)
    fun addCategory(text:String){
        viewModelScope.launch(Dispatchers.IO){
            data.addCategory(
                Category(
                   text
                )
            )
        }
    }

    fun onClickAddCategory(v: View){
        category.value?.let {
            addCategory(it)
        }
    }
    fun onClickGetDataCategory(v:View){
        isonClick.postValue(true)
    }
}