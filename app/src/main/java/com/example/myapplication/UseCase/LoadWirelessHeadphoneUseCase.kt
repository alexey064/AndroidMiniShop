package com.example.myapplication.UseCase

import Models.linked.Product
import com.example.myapplication.Repository.WirelessHeadphoneRepository

class LoadWirelessHeadphoneUseCase(_WirelessHeadphonesRepository : WirelessHeadphoneRepository)  {
    val wirelessHeadphonesRepository : WirelessHeadphoneRepository
    init{
        wirelessHeadphonesRepository=_WirelessHeadphonesRepository
    }
    suspend fun Execute() : List<Product>?
    {
        return wirelessHeadphonesRepository.LoadWirelessHeadphones()
    }
}