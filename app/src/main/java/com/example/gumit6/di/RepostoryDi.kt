package com.example.gumit6.di


import com.example.gumit6.data.repository.Repository
import com.example.gumit6.data.repository.RepositoryImpl
import org.koin.core.module.Module
import org.koin.dsl.module

val RepositoryDi: Module = module {
    single<Repository> { RepositoryImpl(get()) }
}
