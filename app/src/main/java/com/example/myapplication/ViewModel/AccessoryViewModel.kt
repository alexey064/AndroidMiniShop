package com.example.myapplication.ViewModel

import com.example.myapplication.NetworkService.Companion.instance
import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
import Models.linked.Product
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.ArrayList

class AccessoryViewModel : ViewModel() {
    var accessoryLiveData: MutableLiveData<ArrayList<Product>>
    private val TYPE = "Accessory"
    fun init() {
        instance!!.api.GetCatalog(TYPE)!!.enqueue(object : Callback<ArrayList<Product>?> {
            override fun onResponse(
                call: Call<ArrayList<Product>?>,
                response: Response<ArrayList<Product>?>
            ) {
                accessoryLiveData.postValue(response.body())
            }

            override fun onFailure(call: Call<ArrayList<Product>?>, t: Throwable) {}
        })
    }

    init {
        accessoryLiveData = MutableLiveData()
        init()
    }
}