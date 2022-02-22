package com.example.myapplication.UseCase

import Models.linked.Product
import com.example.myapplication.Repository.NotebookRepository

class LoadNotebookUseCase(_data : NotebookRepository) {
    var data: NotebookRepository
    init{
        data=_data
    }
    suspend fun Execute() : List<Product>?
    {
       return data.GetItems()
    }
}