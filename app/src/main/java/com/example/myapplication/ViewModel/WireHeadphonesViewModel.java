package com.example.myapplication.ViewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.NetworkService;

import java.util.ArrayList;

import Models.linked.Product;

public class WireHeadphonesViewModel extends ViewModel {
    MutableLiveData<ArrayList<Product>> WireHeadphonesLiveData;
    private String TYPE="WireHeadphone";

    public WireHeadphonesViewModel()
    {
        WireHeadphonesLiveData= new MutableLiveData<>();
        init();
    }
    public MutableLiveData<ArrayList<Product>> getUserMutableLiveData(){
        return WireHeadphonesLiveData;
    }

    public void init()
    {
        NetworkService.getInstance().getApi().GetCatalog(TYPE).enqueue(new retrofit2.Callback<ArrayList<Product>>() {
            @Override
            public void onResponse(retrofit2.Call<ArrayList<Product>> call, retrofit2.Response<ArrayList<Product>> response) {
                WireHeadphonesLiveData.postValue(response.body());
            }
            @Override
            public void onFailure(retrofit2.Call<ArrayList<Product>> call, Throwable t) {
            }
        });
    }
}
