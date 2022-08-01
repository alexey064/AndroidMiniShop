package com.example.myapplication

import Models.linked.Product
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*
import java.util.ArrayList
import java.util.HashMap

interface MySiteApi {
    @GET("api/newlyAdded")
    suspend fun newlyAdded(@Query("skip") skip: Int, @Query("Count") count: Int): Response<ArrayList<Product>?>?

    @GET("api/MostBuyed")
    suspend fun MostBuyed(@Query("skip") skip: Int, @Query("Count") count: Int): Response<ArrayList<Product>?>?

    @GET("api/MostDiscounted")
    suspend fun MaxDiscounted(@Query("skip") skip: Int, @Query("Count") count: Int): Response<ArrayList<Product>?>?

    @GET("api/catalog")
    suspend fun GetCatalog(@Query("type") type: String?, @Query("skip") skip: Int, @Query("Count")count: Int): Response<ArrayList<Product>?>?

    @GET("api/GetProduct")
    suspend fun GetProduct(@Query("id") id: Int): Response<Product>?

    @POST("api/accountApi/Login")
    suspend fun SignIn(@Body SignData: HashMap<String, String>?): Response<String>?

    @POST("api/accountApi/Register")
    suspend fun Register(@Body RegData : HashMap<String, String>?): Response<String>?

    @GET("api/ShoppingCart")
    fun GetShoppingCart(): Call<ArrayList<Product>?>?

    @POST("api/ShoppingCart")
    fun PostSHoppingCart(@Body data: HashMap<String, Int>?): Call<String>?

    @DELETE("api/ShoppingCart")
    fun DeleteShoppingCart(@Query("id") id: Int): Call<String>?

    @PATCH("api/CompleteOrder")
    fun CompleteOrder(): Call<String>?
}