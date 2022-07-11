package com.example.myapplication.domain.usecases

import Models.linked.Product
import com.example.myapplication.domain.repositories.MaxDiscountedRepository

class GetMaxDiscountedUseCaseImpl(prodRepo :MaxDiscountedRepository) : GetMaxDiscountedUseCase {
    private var ProdRepo: MaxDiscountedRepository
    override suspend fun Execute(skip: Int, count : Int) : ArrayList<Product>?
    {
        return ProdRepo.GetData(skip, count)
    }
    init{
        ProdRepo=prodRepo
    }
}