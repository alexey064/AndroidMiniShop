package com.example.myapplication.domain.usecases

import Models.linked.Product
import com.example.myapplication.domain.repositories.AccessoriesRepository

class GetAccessoryUseCaseImpl(accessoryRepo : AccessoriesRepository) : GetAccessoryUseCase {
    var AccessoryRepo : AccessoriesRepository
    init{
        AccessoryRepo=accessoryRepo
    }
    override suspend fun Execute(skip: Int, count: Int) : ArrayList<Product>? {
        return AccessoryRepo.GetData(skip, count)
    }
}