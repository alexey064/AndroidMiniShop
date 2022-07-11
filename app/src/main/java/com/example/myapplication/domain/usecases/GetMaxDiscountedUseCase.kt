package com.example.myapplication.domain.usecases

import Models.linked.Product

interface GetMaxDiscountedUseCase {
    suspend fun Execute(skip: Int, count : Int) : ArrayList<Product>?
}