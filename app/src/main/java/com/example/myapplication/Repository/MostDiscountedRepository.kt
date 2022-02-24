package com.example.myapplication.Repository

import Models.linked.Product

interface MostDiscountedRepository {
    suspend fun LoadMostdiscounted(): List<Product>?
}