package com.example.myapplication.domain.repositories

import Models.linked.Product
import com.example.myapplication.domain.datasource.AccessoriesNetworkSource
import com.example.myapplication.domain.datasource.SmartphoneNetworkSource

class SmartphoneRepositoryImpl(networkSource : SmartphoneNetworkSource) : SmartphoneRepository{
    var NetworkSource : SmartphoneNetworkSource
    init{
        NetworkSource=networkSource
    }
    override suspend fun GetData(skip: Int, count: Int) : ArrayList<Product>? {
        return NetworkSource.Get(skip, count)
    }

}