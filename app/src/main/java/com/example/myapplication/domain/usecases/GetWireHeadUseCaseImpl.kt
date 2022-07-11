package com.example.myapplication.domain.usecases

import Models.linked.Product
import com.example.myapplication.domain.repositories.WireHeadRepository

class GetWireHeadUseCaseImpl(wirelessHeadRepo : WireHeadRepository) : GetWireHeadUseCase {
    var WireHeadRepo : WireHeadRepository
    init{
        WireHeadRepo=wirelessHeadRepo
    }
    override suspend fun Execute(skip: Int, count: Int) : ArrayList<Product>? {
        return WireHeadRepo.GetData(skip, count)
    }
}