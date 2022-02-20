package com.example.myapplication.Repository

import Models.linked.Product

interface RemoteDataSource {
    suspend fun LoadNotebook(): List<Product>?
}