package com.example.myapplication.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ProdFragFactory(val Id: Int): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(Int::class.java).newInstance(Id)
    }
}