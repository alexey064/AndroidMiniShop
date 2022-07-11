package com.example.myapplication.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
import Models.linked.Product
import com.example.myapplication.domain.usecases.GetNotebookUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*

class NotebookViewModel(getNotebook : GetNotebookUseCase) : ViewModel() {
    var NotebookListLiveData: MutableLiveData<ArrayList<Product>>
    var getNotebookUseCase : GetNotebookUseCase
    init {
        NotebookListLiveData = MutableLiveData()
        getNotebookUseCase=getNotebook
    }
    private val TYPE = "Notebook"

    fun GetNotebook(Skip : Int, Count : Int) {
        CoroutineScope(Dispatchers.IO).launch {
            NotebookListLiveData.postValue(getNotebookUseCase.Execute(Skip, Count))
        }
    }
}