package com.example.myapplication.domain.usecases

import Models.linked.Product
import com.example.myapplication.domain.repositories.WirelessHeadRepository

class GetWirelessHeadUseCaseImpl(wirelessHeadRepo : WirelessHeadRepository) : GetWirelessHeadUseCase {
    var WirelessHeadRepo : WirelessHeadRepository
    init{
        WirelessHeadRepo=wirelessHeadRepo
    }
    override suspend fun Execute(skip: Int, count: Int) : ArrayList<Product>? {
        return WirelessHeadRepo.GetData(skip, count)
    }
}