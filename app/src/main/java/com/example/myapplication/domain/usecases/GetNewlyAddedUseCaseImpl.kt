package com.example.myapplication.domain.usecases

import Models.linked.Product
import com.example.myapplication.domain.repositories.NewlyAddedRepository

class GetNewlyAddedUseCaseImpl(prodRepo:NewlyAddedRepository) :GetNewlyAddedUseCase  {
    private var ProdRepo: NewlyAddedRepository
    public override suspend fun Execute(skip: Int, count : Int) : ArrayList<Product>?
    {
        return ProdRepo.GetData(skip, count)
    }
    init{
        ProdRepo=prodRepo
    }
}