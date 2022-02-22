package com.example.myapplication.Repository

import Models.linked.Product

interface RemoteAccessoryDataSource {
    suspend fun LoadAccessories(): List<Product>?
}