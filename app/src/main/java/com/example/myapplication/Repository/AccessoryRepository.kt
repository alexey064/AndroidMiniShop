package com.example.myapplication.Repository

import Models.linked.Product

interface AccessoryRepository{
    suspend fun LoadAccessories():List<Product>?
}