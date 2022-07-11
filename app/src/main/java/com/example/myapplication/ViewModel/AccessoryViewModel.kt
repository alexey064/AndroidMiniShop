package com.example.myapplication.ViewModel

import com.example.myapplication.NetworkService.Companion.instance
import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
import Models.linked.Product
import com.example.myapplication.domain.repositories.AccessoriesRepository
import com.example.myapplication.domain.usecases.GetAccessoryUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.ArrayList

class AccessoryViewModel(accessoryUseCase: GetAccessoryUseCase) : ViewModel() {
    var AccessoryUseCase : GetAccessoryUseCase
    init{
        AccessoryUseCase=accessoryUseCase
    }
    var accessoryLiveData: MutableLiveData<ArrayList<Product>>
    fun getAccessories(skip : Int, count : Int)
    {
        CoroutineScope(Dispatchers.IO).launch {
            accessoryLiveData.postValue(AccessoryUseCase.Execute(skip, count))
        }
    }
    init {
        accessoryLiveData = MutableLiveData()
    }
}