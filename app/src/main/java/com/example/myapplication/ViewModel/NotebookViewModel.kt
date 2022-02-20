package com.example.myapplication.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
import Models.linked.Product
import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.myapplication.NetworkService
import com.example.myapplication.UseCase.LoadNotebookUseCase
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.koin.core.KoinApplication
import org.koin.core.KoinApplication.Companion.init
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class NotebookViewModel : ViewModel() {
    var userMutableLiveData: MutableLiveData<List<Product>>
    val LoadNotebookUseCase = com.example.myapplication.UseCase.LoadNotebookUseCase()

    private val TYPE = "Notebook"
    fun init() {
        viewModelScope.launch {
          val data =  LoadNotebookUseCase.Execute()
            userMutableLiveData.postValue(data)
        }
   }
    init {
        userMutableLiveData = MutableLiveData()
        KoinApplication.init()
    }
}