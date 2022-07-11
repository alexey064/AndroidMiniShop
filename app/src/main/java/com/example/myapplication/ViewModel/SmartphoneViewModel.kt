package com.example.myapplication.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
import Models.linked.Product
import com.example.myapplication.domain.usecases.GetSmartphoneUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.ArrayList

class SmartphoneViewModel(getSmartphone : GetSmartphoneUseCase) : ViewModel() {
    var SmartphoneListLiveData: MutableLiveData<ArrayList<Product>>
    var getSmartphoneUseCase : GetSmartphoneUseCase
    init {
        SmartphoneListLiveData = MutableLiveData()
        getSmartphoneUseCase=getSmartphone
    }
    fun getSmartphones(skip : Int, count : Int)
    {
        CoroutineScope(Dispatchers.IO).launch {
            SmartphoneListLiveData.postValue(getSmartphoneUseCase.Execute(skip, count))
        }
    }
}