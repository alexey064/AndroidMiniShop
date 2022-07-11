package com.example.myapplication.domain.repositories

import Models.linked.Product
import com.example.myapplication.domain.datasource.MaxDiscountedNetworkSource
import com.example.myapplication.domain.datasource.MaxDiscountedSource

class MaxDiscountedRepositoryImpl(NetworkSrc: MaxDiscountedSource) : MaxDiscountedRepository{
    var NetworkSource : MaxDiscountedSource
    init {
        NetworkSource=NetworkSrc
    }
    override suspend fun GetData(skip: Int, count: Int): ArrayList<Product>? {
        return NetworkSource.get(skip, count)
    }
}