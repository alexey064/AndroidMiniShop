package com.example.myapplication.domain.datasource

import Models.linked.Product

interface NotebookNetworkSource {
    suspend fun Get(skip: Int, count: Int) : ArrayList<Product>?
}