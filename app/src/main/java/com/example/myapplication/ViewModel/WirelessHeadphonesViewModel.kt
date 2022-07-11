package com.example.myapplication.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
import Models.linked.Product
import com.example.myapplication.domain.usecases.GetWirelessHeadUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.ArrayList

class WirelessHeadphonesViewModel(getWireless : GetWirelessHeadUseCase) : ViewModel() {
    var wirelessHeadphonesLiveData: MutableLiveData<ArrayList<Product>>
    var getWirelessHeadUseCase : GetWirelessHeadUseCase
    private val TYPE = "WirelessHeadphone"
    init {
        wirelessHeadphonesLiveData = MutableLiveData()
        getWirelessHeadUseCase=getWireless
    }
    fun getWireless(skip : Int, count : Int)
    {
        CoroutineScope(Dispatchers.IO).launch {
            wirelessHeadphonesLiveData.postValue(getWirelessHeadUseCase.Execute(skip, count))
        }
    }
}