package com.example.myapplication.Repository

import Models.linked.Product

class AccessoryRepositoryImpl(_remote : RemoteAccessoryDataSource) :AccessoryRepository {
    val remote :RemoteAccessoryDataSource
    init {
        remote=_remote
    }
    override suspend fun LoadAccessories(): List<Product>? {
        return remote.LoadAccessories()
    }
}