package com.example.myapplication.Repository

import Models.linked.Product

interface WirelessHeadphoneRepository {
    suspend fun LoadWirelessHeadphones():List<Product>?
}