package com.example.myapplication

import Models.ViewModel.MainPageData
import Models.linked.Product
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*
import java.util.ArrayList
import java.util.HashMap

interface MySiteApi {
    @GET("api/newlyAdded")
    suspend fun newlyAdded()

    @GET("api/catalog")
    suspend fun GetCatalog(@Query("type") type: String?): Response<List<Product>>

    @GET("api/GetProduct")
    suspend fun GetProduct(@Query("id") id: Int): Call<Product?>?

    @POST("api/Login")
    suspend fun SignIn(@Body SignData: HashMap<String?, String?>?): Call<String?>?

    @GET("api/ShoppingCart")
    suspend fun GetShoppingCart(): Call<ArrayList<Product?>?>?

    @POST("api/ShoppingCart")
    suspend fun PostSHoppingCart(@Body data: HashMap<String?, Int?>?): Call<String?>?

    @DELETE("api/ShoppingCart")
    fun DeleteShoppingCart(@Query("id") id: Int): Call<String?>?

    @PATCH("api/CompleteOrder")
    suspend fun CompleteOrder(): Call<String?>?
}