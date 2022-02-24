package com.example.myapplication.DataSource

import Models.linked.Product

interface RemoteSmartphoneDataSource {
    suspend fun LoadSmartphone():List<Product>?
}