package com.example.myapplication.Repository

import Models.linked.Product
import com.example.myapplication.NetworkService

class RemoteAccessoryDataSourceImpl :RemoteAccessoryDataSource{
    suspend override fun LoadAccessories(): List<Product>? {
        val response = NetworkService.instance?.api?.GetCatalog("Accessory")
        if (response?.isSuccessful == true) return response.body()
        else return listOf()
    }
}