package com.example.myapplication.DataSource

import Models.linked.Product

interface RemoteMostDiscountedDataSource {
    suspend fun loadMostDiscounted() : List<Product>?
}