package com.example.myapplication.Repository

import Models.linked.Product
import com.example.myapplication.DataSource.RemoteMostDiscountedDataSource

class MostDiscountedRepositoryImpl(_Remote : RemoteMostDiscountedDataSource) : MostDiscountedRepository {
    val Remote : RemoteMostDiscountedDataSource
    init{
        Remote=_Remote
    }
    override suspend fun LoadMostdiscounted(): List<Product>? {
        return Remote.loadMostDiscounted()
    }
}