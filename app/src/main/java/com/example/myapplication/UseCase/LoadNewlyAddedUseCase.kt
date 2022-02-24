package com.example.myapplication.UseCase

import Models.linked.Product
import com.example.myapplication.Repository.NewlyAddedRepository

class LoadNewlyAddedUseCase(_Repo : NewlyAddedRepository) {
    val Repo : NewlyAddedRepository
    init {
        Repo=_Repo
    }
    suspend fun Execute() : List<Product>?
    {
        return Repo.LoadNewlyAdded()
    }
}