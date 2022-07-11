package com.example.myapplication.domain.repositories

import Models.linked.Product

interface SmartphoneRepository {
    suspend fun GetData(skip : Int, count : Int): ArrayList<Product>?
}