package com.example.gumit6.di

import com.example.gumit6.data.usecase.MovieUseCase
import com.example.gumit6.data.usecase.MovieUseCaseImpl
import org.koin.core.module.Module
import org.koin.dsl.module


val useCaseDi: Module = module {
    single<MovieUseCase> { MovieUseCaseImpl(get()) }
}
