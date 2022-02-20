package com.example.myapplication.Repository

import Models.linked.Product
import com.example.myapplication.NetworkService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception
import java.util.ArrayList

class RemoteDataSourceImpl : RemoteDataSource{
    override suspend fun LoadNotebook(): List<Product>? {
        val response = NetworkService.instance.api2.GetCatalog("Notebook").await()
        if (response.isSuccessful) return response.body()
        else return listOf()
    }
}