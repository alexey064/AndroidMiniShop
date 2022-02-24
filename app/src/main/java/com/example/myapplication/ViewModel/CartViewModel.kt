package com.example.myapplication.ViewModel

import com.example.myapplication.NetworkService.Companion.instance
import androidx.lifecycle.ViewModel
import Models.linked.Product
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.ArrayList

class CartViewModel : ViewModel() {
    var CartLiveData: MutableLiveData<List<Product>>
    fun GetCartLiveData(): MutableLiveData<List<Product>> {
        return CartLiveData
    }

    fun init() {
        viewModelScope.launch {
            val response = instance!!.api.GetShoppingCart()
            if (response.isSuccessful==true)
            {
                CartLiveData.postValue(response.body())
            }
        }
            }
    init {
        CartLiveData = MutableLiveData()
        init()
    }
}