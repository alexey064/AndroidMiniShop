package com.example.myapplication.domain.repositories

import Models.linked.Product
import com.example.myapplication.domain.datasource.AccessoriesNetworkSource
import com.example.myapplication.domain.datasource.WireHeadNetworkSource

class WireHeadRepositoryImpl(networkSource : WireHeadNetworkSource) : WireHeadRepository{
    var NetworkSource : WireHeadNetworkSource
    init{
        NetworkSource=networkSource
    }
    override suspend fun GetData(skip: Int, count: Int) : ArrayList<Product>? {
        return NetworkSource.Get(skip, count)
    }
}