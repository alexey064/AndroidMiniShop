package com.example.myapplication;
import java.util.ArrayList;
import java.util.HashMap;

import Models.ViewModel.MainPageData;
import Models.linked.Product;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Query;
public interface MySiteApi {
    @GET("api/newlyAdded")
    public Call<MainPageData> getNewlyAdded();

    @GET("api/catalog")
     Call<ArrayList<Product>> GetCatalog(@Query("type")String type);

    @GET("api/GetProduct")
    Call<Product> GetProduct(@Query("id") int id);

    @POST("api/Login")
    Call<String> SignIn(@Body HashMap<String, String> SignData);

    @GET("api/ShoppingCart")
    Call<ArrayList<Product>> GetShoppingCart();

    @POST("api/ShoppingCart")
    Call<String> PostSHoppingCart(@Body HashMap<String, Integer> data);

    @DELETE("api/ShoppingCart")
    Call<String> DeleteShoppingCart(@Query("id") int id);

    @PATCH("api/CompleteOrder")
    Call<String> CompleteOrder();
}