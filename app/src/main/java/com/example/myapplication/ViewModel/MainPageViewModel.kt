package com.example.myapplication.ViewModel

import androidx.lifecycle.ViewModel
import Models.ViewModel.MainPageData
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.NetworkService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainPageViewModel : ViewModel() {
    var mainPageData: MutableLiveData<MainPageData>
    fun init() {

    }

    init {
        mainPageData = MutableLiveData()
        init()
    }
}