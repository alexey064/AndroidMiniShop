package com.example.myapplication.domain.repositories

import Models.linked.Product

interface MostBuyedRepository {
    suspend fun GetData(skip : Int, count : Int) : ArrayList<Product>?

}