package com.example.myapplication.domain.repositories

import Models.linked.Product
import com.example.myapplication.domain.datasource.NewlyAddedNetworkSource
import com.example.myapplication.domain.datasource.NewlyAddedSource

class NewlyAddedRepositoryImpl(NetworkSrc : NewlyAddedSource): NewlyAddedRepository {
    var NetworkSource : NewlyAddedSource

    init {
        NetworkSource=NetworkSrc
    }
    override suspend fun GetData(skip: Int, count: Int): ArrayList<Product>? {
        //if cache is old then load data from network
        //else download data from cache
        //cache need to implement
        return NetworkSource.get(skip, count)
    }
}