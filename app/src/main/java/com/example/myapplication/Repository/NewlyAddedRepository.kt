package com.example.myapplication.Repository

import Models.linked.Product

interface NewlyAddedRepository {
    suspend fun LoadNewlyAdded() : List<Product>?
}