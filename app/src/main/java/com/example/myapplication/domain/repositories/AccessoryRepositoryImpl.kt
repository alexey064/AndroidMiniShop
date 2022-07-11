package com.example.myapplication.domain.repositories

import Models.linked.Product
import com.example.myapplication.domain.datasource.AccessoriesNetworkSource

class AccessoryRepositoryImpl(networkSource : AccessoriesNetworkSource) : AccessoriesRepository{
    var NetworkSource : AccessoriesNetworkSource
    init{
        NetworkSource=networkSource
    }
    override suspend fun GetData(skip: Int, count: Int) : ArrayList<Product>? {
        return NetworkSource.Get(skip, count)
    }

}