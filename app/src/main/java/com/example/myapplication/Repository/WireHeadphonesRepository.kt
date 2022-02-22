package com.example.myapplication.Repository

import Models.linked.Product

interface WireHeadphonesRepository {
    suspend fun LoadWireHeadphones() :List<Product>?
}