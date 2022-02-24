package com.example.myapplication.Repository

import Models.linked.Product
import com.example.myapplication.DataSource.RemoteWireHeadphonesDataSource

class WireHeadphonesRepositoryImpl(_Remote : RemoteWireHeadphonesDataSource) : WireHeadphonesRepository {
    val Remote : RemoteWireHeadphonesDataSource
    init{
        Remote=_Remote
    }
    override suspend fun LoadWireHeadphones(): List<Product>? {
        return Remote.LoadAccessories()
    }

}