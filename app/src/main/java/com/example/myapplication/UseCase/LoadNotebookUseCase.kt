package com.example.myapplication.UseCase

import Models.linked.Product
import com.example.myapplication.Repository.NotebookRepository

class LoadNotebookUseCase {
    lateinit var data: NotebookRepository
    suspend fun Execute() : List<Product>
    {
       return data.GetNotebook()
    }
}