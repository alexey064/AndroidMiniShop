package com.example.myapplication.ViewModel

import com.example.myapplication.NetworkService.Companion.instance
import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
import Models.linked.Product
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.ArrayList

class CartViewModel : ViewModel() {
    var CartLiveData: MutableLiveData<ArrayList<Product>>
    fun GetCartLiveData(): MutableLiveData<ArrayList<Product>> {
        return CartLiveData
    }

    fun init() {
        instance!!.api.GetShoppingCart()?.enqueue(object : Callback<ArrayList<Product>?> {
            override fun onResponse(
                call: Call<ArrayList<Product>?>,
                response: Response<ArrayList<Product>?>
            )
            {
                CartLiveData.postValue(response.body())
            }

            override fun onFailure(call: Call<ArrayList<Product>?>, t: Throwable) {}
        })
    }
    init {
        CartLiveData = MutableLiveData()
        init()
    }
}
