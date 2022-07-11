package com.example.myapplication.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
import Models.linked.Product
import com.example.myapplication.domain.usecases.GetWireHeadUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.ArrayList

class WireHeadphonesViewModel(getWireHead: GetWireHeadUseCase) : ViewModel() {
    var WireHeadListLiveData: MutableLiveData<ArrayList<Product>>
    var getWireHeadUseCase : GetWireHeadUseCase
    init {
        WireHeadListLiveData = MutableLiveData()
        getWireHeadUseCase=getWireHead
    }
    fun getWireHead(skip : Int, count : Int)
    {
        CoroutineScope(Dispatchers.IO).launch {
            WireHeadListLiveData.postValue(getWireHeadUseCase.Execute(skip, count))
        }
    }
}