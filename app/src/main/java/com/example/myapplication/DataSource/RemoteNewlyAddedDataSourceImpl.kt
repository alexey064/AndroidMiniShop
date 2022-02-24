package com.example.myapplication.DataSource

import Models.linked.Product
import com.example.myapplication.DataSource.RemoteNewlyAddedDataSource
import com.example.myapplication.NetworkService

class RemoteNewlyAddedDataSourceImpl : RemoteNewlyAddedDataSource {
    override suspend fun LoadNewlyAdded() : List<Product>? {
        var response = NetworkService.instance?.api?.NewlyAdded()
        if (response?.isSuccessful==true){return response.body()}
        return listOf()
    }
}