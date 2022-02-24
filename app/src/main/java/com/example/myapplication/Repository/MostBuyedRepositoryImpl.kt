package com.example.myapplication.Repository

import Models.linked.Product
import com.example.myapplication.DataSource.RemoteMostBuyedDataSource

class MostBuyedRepositoryImpl(_Remote : RemoteMostBuyedDataSource) : MostBuyedRepository {
    val Remote : RemoteMostBuyedDataSource
    init{
        Remote=_Remote
    }
    override suspend fun LoadMostBuyed(): List<Product>? {
        return Remote.LoadMostBuyed()
    }
}