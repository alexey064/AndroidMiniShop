package com.example.myapplication.domain.datasource

import Models.linked.Product

interface SmartphoneNetworkSource {
    suspend fun Get(skip: Int, count: Int) : ArrayList<Product>?
}