package com.example.myapplication.ViewModel

import com.example.myapplication.NetworkService.Companion.instance
import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
import Models.linked.Product
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class NotebookViewModel : ViewModel() {
    var userMutableLiveData: MutableLiveData<ArrayList<Product>>
    var NotebookList = ArrayList<Product>()
    private val TYPE = "Notebook"
    fun init() {
        populateList()
    }

    fun populateList() {
        val startDate = Date()
        Log.d("TIMER", startDate.time.toString())
        instance!!.api.GetCatalog(TYPE)!!.enqueue(object : Callback<ArrayList<Product>?> {
            override fun onResponse(
                call: Call<ArrayList<Product>?>,
                response: Response<ArrayList<Product>?>
            ) {
                val EndDate = Date()
                Log.d("TIMER", EndDate.time.toString())
                Log.d("TIMER", (EndDate.time - startDate.time).toString())
                userMutableLiveData.value = response.body()
            }

            override fun onFailure(call: Call<ArrayList<Product>?>, t: Throwable) {}
        })
    }

    init {
        userMutableLiveData = MutableLiveData()
        init()
    }
}