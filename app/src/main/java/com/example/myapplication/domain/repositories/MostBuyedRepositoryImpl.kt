package com.example.myapplication.domain.repositories

import Models.linked.Product
import com.example.myapplication.domain.datasource.MostBuyedNetworkSource
import com.example.myapplication.domain.datasource.MostBuyedSource

class MostBuyedRepositoryImpl(NetworkSrc : MostBuyedSource) : MostBuyedRepository {
    var NetworkSource : MostBuyedSource
    init
    {
        NetworkSource=NetworkSrc
    }
    override suspend fun GetData(skip: Int, count: Int): ArrayList<Product>? {
        //if cache is old then load data from network
        //else download data from cache
        //cache need to implement
        return NetworkSource.get(skip, count)
    }
}