package com.example.myapplication.DataSource

import Models.linked.Product

interface RemoteWireHeadphonesDataSource {
    suspend fun LoadAccessories() : List<Product>?
}