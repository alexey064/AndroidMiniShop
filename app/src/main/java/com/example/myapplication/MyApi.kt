package com.example.myapplication

import Models.linked.Product
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.ArrayList

interface MyApi {

    @GET("api/catalog")
    fun GetCatalog(@Query("type") type: String?): Response<ArrayList<Product>>
}