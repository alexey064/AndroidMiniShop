package com.example.myapplication.Repository

import Models.linked.Product

interface MostBuyedRepository {
    suspend fun LoadMostBuyed() : List<Product>?
}