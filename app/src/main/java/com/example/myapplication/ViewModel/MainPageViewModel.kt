package com.example.myapplication.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
import Models.linked.Product
import com.example.myapplication.domain.usecases.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainPageViewModel(newlyAddedUseCase : GetNewlyAddedUseCase, maxDiscountedUseCase : GetMaxDiscountedUseCase,
                        mostBuyedUseCase :GetMostBuyedUseCase ) : ViewModel() {
    var NewlyAdded: MutableLiveData<ArrayList<Product>>
    var MostBuyed : MutableLiveData<ArrayList<Product>>
    var MaxDiscounted : MutableLiveData<ArrayList<Product>>
    var NewlyAddedUseCase : GetNewlyAddedUseCase
    var MostBuyedUseCase : GetMostBuyedUseCase
    var MaxDiscountedUseCase : GetMaxDiscountedUseCase
    init {
        NewlyAdded = MutableLiveData()
        MostBuyed = MutableLiveData()
        MaxDiscounted=MutableLiveData()
        NewlyAddedUseCase = newlyAddedUseCase
        MostBuyedUseCase = mostBuyedUseCase
        MaxDiscountedUseCase= maxDiscountedUseCase
    }
    fun getNewlyAdded(skip : Int, count : Int)
    {
        CoroutineScope(Dispatchers.IO).launch {
            NewlyAdded.postValue(NewlyAddedUseCase.Execute(skip, count))
        }
    }
    fun getMostBuyed()
    {
        CoroutineScope(Dispatchers.IO).launch {

        }
    }
    fun getMaxDiscounted()
    {

    }
}