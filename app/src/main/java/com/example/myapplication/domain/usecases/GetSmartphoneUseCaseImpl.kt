package com.example.myapplication.domain.usecases

import Models.linked.Product
import com.example.myapplication.domain.repositories.SmartphoneRepository

class GetSmartphoneUseCaseImpl(smartphoneRepo : SmartphoneRepository) : GetSmartphoneUseCase {
    var SmartphoneRepo : SmartphoneRepository
    init{
        SmartphoneRepo=smartphoneRepo
    }
    override suspend fun Execute(skip: Int, count: Int) : ArrayList<Product>? {
        return SmartphoneRepo.GetData(skip, count)
    }
}