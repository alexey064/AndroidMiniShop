package com.example.myapplication.Repository

import Models.linked.Product
import com.example.myapplication.DataSource.RemoteNewlyAddedDataSource

class NewlyAddedRepositoryImpl(_Remote : RemoteNewlyAddedDataSource) : NewlyAddedRepository{
    val Remote : RemoteNewlyAddedDataSource
    init{
        Remote=_Remote
    }
    override suspend fun LoadNewlyAdded(): List<Product>? {
        return Remote.LoadNewlyAdded()
    }
}