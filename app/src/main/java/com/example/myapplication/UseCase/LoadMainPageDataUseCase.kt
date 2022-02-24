package com.example.myapplication.UseCase

import Models.ViewModel.MainPageData

class LoadMainPageDataUseCase( _LoadMostBuyed : LoadMostBuyedUseCase,
                              _LoadNewlyAdded : LoadNewlyAddedUseCase,
                              _LoadMostDiscounted : LoadMostDiscountedUseCase) {
    val LoadMostBuyed : LoadMostBuyedUseCase
    val LoadNewlyAdded : LoadNewlyAddedUseCase
    val LoadMostDiscounted : LoadMostDiscountedUseCase
    init {
        LoadMostBuyed=_LoadMostBuyed
        LoadNewlyAdded=_LoadNewlyAdded
        LoadMostDiscounted=_LoadMostDiscounted
    }
    suspend fun Execute() : MainPageData
    {
        var mainPageData : MainPageData = MainPageData()
        mainPageData.newlyAdded=LoadNewlyAdded.Execute()
        mainPageData.mostBuyed= LoadMostBuyed.Execute()
        mainPageData.maxDiscounted=LoadMostDiscounted.Execute()
        return mainPageData
    }
}