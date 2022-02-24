package com.example.myapplication.Repository

import Models.linked.Product
import com.example.myapplication.DataSource.RemoteWirelessHeadphonesDataSource

class WirelessHeadphoneRepositoryImpl(_Remote : RemoteWirelessHeadphonesDataSource) : WirelessHeadphoneRepository {
    val Remote : RemoteWirelessHeadphonesDataSource
    init{
        Remote=_Remote
    }
    override suspend fun LoadWirelessHeadphones(): List<Product>? {
        return Remote.LoadWirelessHeadphones()
    }
}