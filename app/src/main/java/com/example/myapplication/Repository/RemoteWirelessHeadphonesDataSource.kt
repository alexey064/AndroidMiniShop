package com.example.myapplication.Repository

import Models.linked.Product

interface RemoteWirelessHeadphonesDataSource {
    suspend fun LoadWirelessHeadphones(): List<Product>?
}