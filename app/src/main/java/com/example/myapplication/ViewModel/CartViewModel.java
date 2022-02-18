package com.example.myapplication.ViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.NetworkService;

import java.util.ArrayList;

import Models.linked.Product;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class CartViewModel extends ViewModel {
    MutableLiveData<ArrayList<Product>> CartLiveData;
    public CartViewModel()
    {
        CartLiveData= new MutableLiveData<>();
        init();
    }
    public MutableLiveData<ArrayList<Product>> GetCartLiveData()
    {
        return CartLiveData;
    }
    public void init()
    {
        NetworkService.getInstance().getApi().GetShoppingCart().enqueue(new Callback<ArrayList<Product>>() {
            @Override
            public void onResponse(Call<ArrayList<Product>> call, Response<ArrayList<Product>> response) {
                CartLiveData.postValue(response.body());
            }
            @Override
            public void onFailure(Call<ArrayList<Product>> call, Throwable t) {
            }
        });
    }
}