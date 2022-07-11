package com.example.myapplication.domain.repositories

import Models.linked.Product

interface NotebookRepository {
    suspend fun GetData(skip : Int, count : Int): ArrayList<Product>?
}