package com.example.myapplication.ViewModel

import com.example.myapplication.NetworkService.Companion.instance
import androidx.lifecycle.ViewModel
import Models.linked.Product
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.myapplication.NetworkService
import com.example.myapplication.UseCase.LoadSmartphoneUseCase
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.ArrayList

class SmartphoneViewModel(_loadSmartphoneUseCase : LoadSmartphoneUseCase) : ViewModel() {
    var userMutableLiveData: MutableLiveData<List<Product>>
    val loadSmartphoneUseCase : LoadSmartphoneUseCase
    var TYPE = "Smartphone"
    fun init() {
        viewModelScope.launch {
            val data = loadSmartphoneUseCase.Execute()
            userMutableLiveData.postValue(data)
        }
    }
    init {
        loadSmartphoneUseCase=_loadSmartphoneUseCase
        userMutableLiveData = MutableLiveData()
        init()
    }

}