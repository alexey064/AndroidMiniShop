package com.example.myapplication.UseCase

import Models.linked.Product
import com.example.myapplication.Repository.MostBuyedRepository

class LoadMostBuyedUseCase(_Repo : MostBuyedRepository) {
    val Repo : MostBuyedRepository
    init{
        Repo=_Repo
    }
    suspend fun Execute() : List<Product>?
    {
        return Repo.LoadMostBuyed()
    }
}