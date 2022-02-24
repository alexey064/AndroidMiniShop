package com.example.myapplication.ViewModel

import com.example.myapplication.NetworkService.Companion.instance
import androidx.lifecycle.ViewModel
import Models.linked.Product
import com.example.myapplication.NetworkService
import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.myapplication.ViewModel.ProductViewModel
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductViewModel(id: Int) : ViewModel() {
    var product: MutableLiveData<Product?>
    fun GetProduct(): MutableLiveData<Product?> {
        return product
    }
    init {
        product = MutableLiveData()
        init(id)
    }

    fun init(id: Int) {
        viewModelScope.launch {
            val response = NetworkService.instance?.api?.GetProduct(id)
            if (response?.isSuccessful==true){
                product.value = response.body()
            }
        }
    }


    class MyViewModelFactory(private val mParam: Int) : ViewModelProvider.Factory {
        private val mApplication: Application? = null
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return ProductViewModel(mParam) as T
        }
    }
}