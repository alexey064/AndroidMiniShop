package com.example.myapplication.ViewModel

import androidx.lifecycle.ViewModel
import Models.linked.Product
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.myapplication.UseCase.LoadWirelessHeadphoneUseCase
import kotlinx.coroutines.launch
import java.util.ArrayList

class WirelessHeadphonesViewModel(_loadWirelessHeadphoneUseCase : LoadWirelessHeadphoneUseCase) : ViewModel() {
    var wirelessHeadphonesLiveData: MutableLiveData<List<Product>>
    val wireHeadphoneUseCase : LoadWirelessHeadphoneUseCase
    fun init() {
        viewModelScope.launch {
            val data = wireHeadphoneUseCase.Execute()
            wirelessHeadphonesLiveData.postValue(data)
        }
    }
    init {
        wireHeadphoneUseCase=_loadWirelessHeadphoneUseCase
        wirelessHeadphonesLiveData = MutableLiveData()
        init()
    }
}