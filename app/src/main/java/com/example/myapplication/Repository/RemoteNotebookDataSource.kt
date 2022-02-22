package com.example.myapplication.Repository

import Models.linked.Product

interface RemoteNotebookDataSource {
    suspend fun LoadNotebook(): List<Product>?
}