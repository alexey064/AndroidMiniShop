package com.example.myapplication.Repository

import Models.linked.Product

class NotebookRepositoryImpl :NotebookRepository {
    lateinit var RemDataSource: RemoteDataSource;
    override suspend fun GetNotebook(): List<Product> {
        val result = RemDataSource.LoadNotebook()?: listOf()
        if(result.isEmpty())
        {
            return result
        }
        return result
    }

    override suspend fun SaveNotebook() {
        TODO("Not yet implemented")
    }
}