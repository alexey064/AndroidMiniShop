package com.example.myapplication.ViewModel

import com.example.myapplication.NetworkService.Companion.instance
import androidx.lifecycle.ViewModel
import Models.linked.Product
import com.example.myapplication.NetworkService
import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.ViewModel.ProductViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductViewModel(id: Int) : ViewModel() {
    /*var product: MutableLiveData<Product?>
    fun GetProduct(): MutableLiveData<Product?> {
        return product
    }

    fun init(id: Int) {
        instance!!.api.GetProduct(id).enqueue(object : Callback<Product?> {
            override fun onResponse(call: Call<Product?>, response: Response<Product?>) {
                product.value = response.body()
            }

            override fun onFailure(call: Call<Product?>, t: Throwable) {}
        })
    }

    class MyViewModelFactory(private val mParam: Int) : Factory {
        private val mApplication: Application? = null
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return ProductViewModel(mParam) as T
        }
    }

    init {
        product = MutableLiveData()
        init(id)
    }
     */
}