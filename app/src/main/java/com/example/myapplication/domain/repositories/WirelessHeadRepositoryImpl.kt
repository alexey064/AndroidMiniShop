package com.example.myapplication.domain.repositories

import Models.linked.Product
import com.example.myapplication.domain.datasource.WirelessHeadNetworkSource

class WirelessHeadRepositoryImpl(networkSource : WirelessHeadNetworkSource) : WirelessHeadRepository{
    var NetworkSource : WirelessHeadNetworkSource
    init{
        NetworkSource=networkSource
    }
    override suspend fun GetData(skip: Int, count: Int) : ArrayList<Product>? {
        return NetworkSource.Get(skip, count)
    }
}