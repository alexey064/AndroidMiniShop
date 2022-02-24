package com.example.myapplication.DataSource

import Models.linked.Product

interface RemoteMostBuyedDataSource {
    suspend fun LoadMostBuyed() : List<Product>?
}