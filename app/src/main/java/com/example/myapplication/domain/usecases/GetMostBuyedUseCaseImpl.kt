package com.example.myapplication.domain.usecases

import Models.linked.Product
import com.example.myapplication.domain.repositories.MostBuyedRepository

class GetMostBuyedUseCaseImpl(prodRepo: MostBuyedRepository) : GetMostBuyedUseCase {
    private var ProdRepo: MostBuyedRepository
    public override suspend fun Execute(skip: Int, count : Int) : ArrayList<Product>?
    {
        return ProdRepo.GetData(skip, count)
    }
    init{
        ProdRepo=prodRepo
    }
}