package com.example.myapplication.domain.datasource

import Models.linked.Product
import com.example.myapplication.NetworkService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class WirelessHeadNetworkSourceImpl : WirelessHeadNetworkSource {
init{

}
    override suspend fun Get(skip: Int, count: Int): ArrayList<Product>? {
        val resposne = NetworkService.instance!!.api.GetCatalog("WirelessHeadphone", skip, count)
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