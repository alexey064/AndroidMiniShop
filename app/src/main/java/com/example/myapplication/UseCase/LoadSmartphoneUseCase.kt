package com.example.myapplication.UseCase

import Models.linked.Product
import com.example.myapplication.Repository.SmartphoneRepository

class LoadSmartphoneUseCase(_repo : SmartphoneRepository) {
    val Repo :SmartphoneRepository
    init{
        Repo=_repo
    }
    suspend fun Execute() : List<Product>?
    {
        return Repo.LoadSmartphones()
    }
}