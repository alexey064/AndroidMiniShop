package com.example.myapplication.Repository

import Models.linked.Product
import com.example.myapplication.NetworkService

class RemoteWirelessHeadphonesDataSourceImpl : RemoteWirelessHeadphonesDataSource{
    override suspend fun LoadWirelessHeadphones(): List<Product>? {
        val response = NetworkService.instance?.api?.GetCatalog("WirelessHeadphone")
        if (response?.isSuccessful==true){return response.body()}
        return listOf()
    }
}