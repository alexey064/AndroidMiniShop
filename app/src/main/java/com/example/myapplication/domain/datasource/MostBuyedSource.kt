package com.example.myapplication.domain.datasource

import Models.linked.Product

interface MostBuyedSource {
    suspend fun get(skip: Int, count: Int): ArrayList<Product>?
}