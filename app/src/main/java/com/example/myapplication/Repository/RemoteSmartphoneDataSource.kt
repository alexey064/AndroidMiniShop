package com.example.myapplication.Repository

import Models.linked.Product

interface RemoteSmartphoneDataSource {
    suspend fun LoadSmartphone():List<Product>?
}