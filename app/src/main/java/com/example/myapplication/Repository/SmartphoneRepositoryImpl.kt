package com.example.myapplication.Repository

import Models.linked.Product

class SmartphoneRepositoryImpl(_Remote : RemoteSmartphoneDataSource) : SmartphoneRepository {
    val Remote:RemoteSmartphoneDataSource
    init{
        Remote=_Remote
    }
    override suspend fun LoadSmartphones(): List<Product>? {
        return Remote.LoadSmartphone()
    }
}