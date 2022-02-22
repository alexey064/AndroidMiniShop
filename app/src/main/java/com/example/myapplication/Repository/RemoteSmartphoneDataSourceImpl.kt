package com.example.myapplication.Repository

import Models.linked.Product
import com.example.myapplication.NetworkService

class RemoteSmartphoneDataSourceImpl : RemoteSmartphoneDataSource {
    override suspend fun LoadSmartphone(): List<Product>? {
        val response = NetworkService.instance?.api?.GetCatalog("Smartphone")
        if (response?.isSuccessful==true){return response.body()}
        else return listOf()
    }
}