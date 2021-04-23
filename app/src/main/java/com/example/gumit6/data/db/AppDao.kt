package com.example.gumit6.data.db

import androidx.room.*
import com.example.gumit6.data.db.model.Category
import com.example.gumit6.data.db.model.Movie

@Dao
interface AppDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE) // khi trung thi bo qua
    suspend fun addCategory(categories: Category)
    @Insert(onConflict = OnConflictStrategy.IGNORE) // khi trung thi bo qua
    suspend fun addMovie(movie: Movie)

//    @Delete
//    suspend fun deleteTimeTable(vararg timetable: TimeTable )

    @Query("select * from Category")
    suspend fun getCategory():MutableList<Category>

    @Query("select * from Movie where Movie.idCategory=:idCategory")
    suspend fun getMoviebyIdCategory(idCategory: String):MutableList<Movie>

    @Query("select * from Movie")
    suspend fun getMoviebyidCNull():MutableList<Movie>

    @Query("select * from Movie where Movie.idCategory=:idCategory and Movie.name like '%' ||:key || '%'")
    suspend fun getMoviebyIdCategoryAndKeyword(idCategory: String,key:String):MutableList<Movie>

}