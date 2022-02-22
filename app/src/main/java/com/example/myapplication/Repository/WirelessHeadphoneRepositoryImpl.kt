package com.example.myapplication.Repository

import Models.linked.Product

class WirelessHeadphoneRepositoryImpl(_Remote : RemoteWirelessHeadphonesDataSource) : WirelessHeadphoneRepository {
    val Remote : RemoteWirelessHeadphonesDataSource
    init{
        Remote=_Remote
    }
    override suspend fun LoadWirelessHeadphones(): List<Product>? {
        return Remote.LoadWirelessHeadphones()
    }
}