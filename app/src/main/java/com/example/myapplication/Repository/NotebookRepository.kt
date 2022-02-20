package com.example.myapplication.Repository

import Models.linked.Product

interface NotebookRepository {
    suspend fun GetNotebook() : List<Product>
    suspend fun SaveNotebook()
}