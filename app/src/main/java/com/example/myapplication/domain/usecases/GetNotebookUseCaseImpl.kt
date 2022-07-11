package com.example.myapplication.domain.usecases

import Models.linked.Product
import com.example.myapplication.domain.repositories.AccessoriesRepository
import com.example.myapplication.domain.repositories.NotebookRepository

class GetNotebookUseCaseImpl(notebookRepo : NotebookRepository) : GetNotebookUseCase {
    var NotebookRepo : NotebookRepository
    init{
        NotebookRepo=notebookRepo
    }
    override suspend fun Execute(skip: Int, count: Int) : ArrayList<Product>? {
        return NotebookRepo.GetData(skip, count)
    }
}