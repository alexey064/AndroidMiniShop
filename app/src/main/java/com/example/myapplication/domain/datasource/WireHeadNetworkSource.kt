package com.example.myapplication.domain.datasource

import Models.linked.Product

interface WireHeadNetworkSource {
    suspend fun Get(skip: Int, count: Int) : ArrayList<Product>?
}