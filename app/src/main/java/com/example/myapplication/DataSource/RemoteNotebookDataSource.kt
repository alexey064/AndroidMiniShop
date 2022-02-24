package com.example.myapplication.DataSource

import Models.linked.Product

interface RemoteNotebookDataSource {
    suspend fun LoadNotebook(): List<Product>?
}