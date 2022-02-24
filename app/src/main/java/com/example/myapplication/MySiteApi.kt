package com.example.myapplication

import Models.linked.Product
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*
import java.util.ArrayList
import java.util.HashMap

interface MySiteApi {
    @GET("api/newlyAdded")
    suspend fun NewlyAdded() : Response<List<Product>>

    @GET("api/MostBuyed")
    suspend fun MostBuyed(): Response<List<Product>>

    @GET("api/MostDiscounted")
    suspend fun MostDiscounted() : Response<List<Product>>

    @GET("api/catalog")
    suspend fun GetCatalog(@Query("type") type: String?): Response<List<Product>>

    @GET("api/GetProduct")
    suspend fun GetProduct(@Query("id") id: Int): Response<Product?>?

    @POST("api/Login")
    suspend fun SignIn(@Body SignData: HashMap<String, String>): Response<String>

    @GET("api/ShoppingCart")
    suspend fun GetShoppingCart(): Response<List<Product>>

    @POST("api/ShoppingCart")
    suspend fun PostSHoppingCart(@Body data: HashMap<String, Int>): Response<String?>?

    @DELETE("api/ShoppingCart")
    fun DeleteShoppingCart(@Query("id") id: Int): Response<String?>?

    @PATCH("api/CompleteOrder")
    suspend fun CompleteOrder(): Response<String?>?
}