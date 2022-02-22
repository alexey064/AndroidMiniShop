package com.example.myapplication.Repository

import Models.linked.Product

interface SmartphoneRepository {
    suspend fun LoadSmartphones(): List<Product>?
}