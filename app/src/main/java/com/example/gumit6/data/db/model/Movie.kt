package com.example.gumit6.data.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey
//
@Entity
data class Movie(@PrimaryKey(autoGenerate = true) val id:Int,val name:String,val idCategory:String)