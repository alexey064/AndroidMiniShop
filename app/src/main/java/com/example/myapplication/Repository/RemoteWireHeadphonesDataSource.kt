package com.example.myapplication.Repository

import Models.linked.Product

interface RemoteWireHeadphonesDataSource {
    suspend fun LoadAccessories() : List<Product>?
}