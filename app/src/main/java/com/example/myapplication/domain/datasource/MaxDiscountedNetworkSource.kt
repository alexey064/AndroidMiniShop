package com.example.myapplication.domain.datasource

import Models.linked.Product
import com.example.myapplication.NetworkService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MaxDiscountedNetworkSource : MaxDiscountedSource {
    init{

    }
    override suspend fun get(skip: Int, count: Int): ArrayList<Product>? {
        val resposne = NetworkService.instance!!.api.MaxDiscounted(skip, count)
        return withContext(Dispatchers.IO)
        {
            resposne.let {
                if (resposne!!.isSuccessful) {
                    return@withContext resposne.body()
                } else {
                    return@withContext ArrayList<Product>()
                }
            }
        }
    }
}