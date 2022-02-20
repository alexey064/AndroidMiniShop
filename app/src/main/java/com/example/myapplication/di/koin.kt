package com.example.myapplication.di

import com.example.myapplication.Repository.NotebookRepository
import com.example.myapplication.Repository.NotebookRepositoryImpl
import com.example.myapplication.Repository.RemoteDataSource
import com.example.myapplication.Repository.RemoteDataSourceImpl
import com.example.myapplication.UseCase.LoadNotebookUseCase
import org.koin.dsl.module

val appmodule= module{
    single<RemoteDataSource> { RemoteDataSourceImpl() }
    single<NotebookRepository>{ NotebookRepositoryImpl() }
    single<LoadNotebookUseCase>{ LoadNotebookUseCase() }
}