package com.example.gumit6.di

import org.koin.android.ext.koin.androidApplication
import com.example.gumit6.data.db.AppDatabase
import org.koin.dsl.module


val appdaoModule= module {
    single { AppDatabase.getInstance(androidApplication()).appDao()}
}