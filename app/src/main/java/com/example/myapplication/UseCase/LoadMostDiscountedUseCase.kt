package com.example.myapplication.UseCase

import Models.linked.Product
import com.example.myapplication.Repository.MostDiscountedRepository

class LoadMostDiscountedUseCase(_Repo : MostDiscountedRepository) {
    val Repo :MostDiscountedRepository
    init{
        Repo=_Repo
    }
    suspend fun Execute() : List<Product>?
    {
        return Repo.LoadMostdiscounted()
    }
}