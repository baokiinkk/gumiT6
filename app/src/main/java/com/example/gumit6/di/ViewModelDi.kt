package com.example.gumit6.di

import com.example.gumit6.ui.addcategory.AddCategoriesViewmodel
import com.example.gumit6.ui.addmovie.AddMovieViewmodel
import com.example.gumit6.ui.movies.MovieFragment
import com.example.gumit6.ui.movies.MovieViewmodel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

// File này ta sẽ tạo ra các module của tầng ViewModel

val HomeViewmodelDi: Module = module {
    viewModel { AddCategoriesViewmodel(get()) }
    viewModel { AddMovieViewmodel(get()) }
    viewModel { MovieViewmodel(get()) }
}
