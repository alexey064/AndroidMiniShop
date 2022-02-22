package com.example.myapplication.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
import Models.linked.Product
import androidx.lifecycle.viewModelScope
import com.example.myapplication.UseCase.LoadNotebookUseCase
import kotlinx.coroutines.launch

class NotebookViewModel(_loadNotebookUseCase : LoadNotebookUseCase) : ViewModel() {
    var userMutableLiveData: MutableLiveData<List<Product>>
    var loadNotebookUseCase :LoadNotebookUseCase

    fun init() {
        viewModelScope.launch {
          val data =  loadNotebookUseCase.Execute()
            userMutableLiveData.postValue(data)
        }
   }
    init {
        loadNotebookUseCase=_loadNotebookUseCase
        userMutableLiveData = MutableLiveData()
        init()
    }
}