package com.example.myapplication.ViewModel

import androidx.lifecycle.ViewModel
import Models.ViewModel.MainPageData
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.NetworkService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainPageViewModel : ViewModel() {
    /*var mainPageData: MutableLiveData<MainPageData?>
    fun init() {
        instance!!.api.newlyAdded.enqueue(object : Callback<MainPageData?> {
            override fun onResponse(call: Call<MainPageData?>, response: Response<MainPageData?>) {
                mainPageData.postValue(response.body())
            }

            override fun onFailure(call: Call<MainPageData?>, t: Throwable) {}
        })
    }

    init {
        mainPageData = MutableLiveData()
        init()
    }
     */
}