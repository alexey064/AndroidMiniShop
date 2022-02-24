package com.example.myapplication.DataSource

import Models.linked.Product

interface RemoteWirelessHeadphonesDataSource {
    suspend fun LoadWirelessHeadphones(): List<Product>?
}