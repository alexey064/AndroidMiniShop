package com.example.myapplication.ViewModel

import com.example.myapplication.NetworkService.Companion.instance
import androidx.lifecycle.ViewModel
import Models.linked.Product
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.myapplication.UseCase.LoadAccessoryUseCase
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.ArrayList

class AccessoryViewModel(_loadAccessoryUseCase : LoadAccessoryUseCase) : ViewModel() {
    val loadAccessoryUseCase :LoadAccessoryUseCase
    var accessoryLiveData: MutableLiveData<List<Product>> get() = field
    fun init() {
        viewModelScope.launch {
            val data = loadAccessoryUseCase.execute()
            accessoryLiveData.postValue(data)
        }
    }
    init {
        accessoryLiveData = MutableLiveData()
        loadAccessoryUseCase=_loadAccessoryUseCase
        init()
    }
}