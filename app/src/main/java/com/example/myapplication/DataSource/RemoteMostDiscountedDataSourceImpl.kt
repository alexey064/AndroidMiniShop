package com.example.myapplication.DataSource

import Models.linked.Product
import com.example.myapplication.DataSource.RemoteMostDiscountedDataSource
import com.example.myapplication.NetworkService

class RemoteMostDiscountedDataSourceImpl : RemoteMostDiscountedDataSource {
    override suspend fun loadMostDiscounted(): List<Product>? {
        val response = NetworkService.instance?.api?.MostDiscounted()
        if (response?.isSuccessful==true){return response.body()}
        return listOf()
    }
}