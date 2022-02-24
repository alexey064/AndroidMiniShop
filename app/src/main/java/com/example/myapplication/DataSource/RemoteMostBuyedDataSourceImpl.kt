package com.example.myapplication.DataSource

import Models.linked.Product
import com.example.myapplication.DataSource.RemoteMostBuyedDataSource
import com.example.myapplication.NetworkService

class RemoteMostBuyedDataSourceImpl() : RemoteMostBuyedDataSource {
    override suspend fun LoadMostBuyed(): List<Product>? {
        val response = NetworkService.instance?.api?.MostBuyed()
        if (response?.isSuccessful==true){return response.body()}
        return listOf()
    }
}