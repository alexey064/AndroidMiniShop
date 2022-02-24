package com.example.myapplication.DataSource

import Models.linked.Product

interface RemoteAccessoryDataSource {
    suspend fun LoadAccessories(): List<Product>?
}