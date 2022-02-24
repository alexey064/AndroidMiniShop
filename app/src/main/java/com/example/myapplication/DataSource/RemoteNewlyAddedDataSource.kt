package com.example.myapplication.DataSource

import Models.linked.Product

interface RemoteNewlyAddedDataSource {
    suspend fun LoadNewlyAdded() : List<Product>?
}