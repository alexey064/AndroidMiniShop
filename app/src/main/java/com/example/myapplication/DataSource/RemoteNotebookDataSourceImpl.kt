package com.example.myapplication.DataSource

import Models.linked.Product
import com.example.myapplication.DataSource.RemoteNotebookDataSource
import com.example.myapplication.NetworkService

class RemoteNotebookDataSourceImpl : RemoteNotebookDataSource {
    override suspend fun LoadNotebook(): List<Product>? {
        val response = NetworkService.instance?.api?.GetCatalog("Notebook")
        if (response?.isSuccessful == true) return response.body()
        else return listOf()
    }
}