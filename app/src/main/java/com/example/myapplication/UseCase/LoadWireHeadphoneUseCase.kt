package com.example.myapplication.UseCase

import Models.linked.Product
import com.example.myapplication.Repository.WireHeadphonesRepository

class LoadWireHeadphoneUseCase(_repo : WireHeadphonesRepository) {
    val Repo : WireHeadphonesRepository
    init{
        Repo= _repo
    }
    suspend fun Execute() : List<Product>?
    {
        return Repo.LoadWireHeadphones()
    }
}