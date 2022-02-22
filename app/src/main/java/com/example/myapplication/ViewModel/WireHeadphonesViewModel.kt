package com.example.myapplication.ViewModel

import androidx.lifecycle.ViewModel
import Models.linked.Product
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.myapplication.UseCase.LoadWireHeadphoneUseCase
import kotlinx.coroutines.launch


class WireHeadphonesViewModel(_LoadWireHeadphoneUseCase : LoadWireHeadphoneUseCase) : ViewModel() {
    var userMutableLiveData: MutableLiveData<List<Product>>
    val loadWireHeadphoneUseCase : LoadWireHeadphoneUseCase
    fun init() {
        viewModelScope.launch {
            val data =loadWireHeadphoneUseCase.Execute()
            userMutableLiveData.postValue(data)
        }
    }
    init {
        loadWireHeadphoneUseCase=_LoadWireHeadphoneUseCase
        userMutableLiveData = MutableLiveData()
        init()
    }
}