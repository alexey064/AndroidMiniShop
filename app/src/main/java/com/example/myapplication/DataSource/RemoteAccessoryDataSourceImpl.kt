package com.example.myapplication.DataSource

import Models.linked.Product
import com.example.myapplication.DataSource.RemoteAccessoryDataSource
import com.example.myapplication.NetworkService

class RemoteAccessoryDataSourceImpl : RemoteAccessoryDataSource {
    suspend override fun LoadAccessories(): List<Product>? {
        val response = NetworkService.instance?.api?.GetCatalog("Accessory")
        if (response?.isSuccessful == true) return response.body()
        else return listOf()
    }
}