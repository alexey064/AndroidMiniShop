package com.example.myapplication.DataSource

import Models.linked.Product
import com.example.myapplication.DataSource.RemoteWireHeadphonesDataSource
import com.example.myapplication.NetworkService

class RemoteWireHeadphonesDataSourceImpl : RemoteWireHeadphonesDataSource {
    override suspend fun LoadAccessories(): List<Product>? {
        val response = NetworkService.instance?.api?.GetCatalog("WireHeadphone")
        if (response?.isSuccessful==true){ return response.body()}
        return listOf()
    }
}