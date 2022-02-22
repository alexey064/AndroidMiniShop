package com.example.myapplication.Repository

import Models.linked.Product

interface NotebookRepository {
    suspend fun GetItems() : List<Product>?
}