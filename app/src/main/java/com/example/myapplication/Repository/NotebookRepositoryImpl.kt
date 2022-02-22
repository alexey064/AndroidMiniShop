package com.example.myapplication.Repository

import Models.linked.Product

class NotebookRepositoryImpl(_RemDataSource:RemoteNotebookDataSource) :NotebookRepository {
    var RemDataSource: RemoteNotebookDataSource;
    init{
        RemDataSource=_RemDataSource
    }
    override suspend fun GetItems(): List<Product> {
        val result = RemDataSource.LoadNotebook()?: listOf()
        if(result.isEmpty())
        {
            return result
        }
        return result
    }
}