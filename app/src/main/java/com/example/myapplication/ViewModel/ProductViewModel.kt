package com.example.myapplication.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
import Models.linked.Product
import com.example.myapplication.NetworkService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class ProductViewModel() : ViewModel() {
    var product: MutableLiveData<Product>

    fun getProduct(id: Int) {
        runBlocking {
            val response = NetworkService.instance!!.api.GetProduct(id)
            if (response!!.isSuccessful)
            {
                product.value = response.body()
            }
        }
    }

    init {
        product = MutableLiveData()
    }
}