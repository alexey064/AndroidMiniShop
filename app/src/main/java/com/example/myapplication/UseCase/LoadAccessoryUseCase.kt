package com.example.myapplication.UseCase

import Models.linked.Product
import com.example.myapplication.Repository.AccessoryRepository
import com.example.myapplication.Repository.NotebookRepository

class LoadAccessoryUseCase(repo : AccessoryRepository) {
    val repo:AccessoryRepository
    init{
       this.repo =repo
    }
    suspend fun execute() : List<Product>?{
        return repo.LoadAccessories()
    }
}