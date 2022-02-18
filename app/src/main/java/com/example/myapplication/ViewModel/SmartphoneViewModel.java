package com.example.myapplication.ViewModel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.NetworkService;

import java.util.ArrayList;
import java.util.Date;

import Models.linked.Product;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SmartphoneViewModel extends ViewModel {
    MutableLiveData<ArrayList<Product>> SmartphoneLiveData;
    ArrayList<Product> products = new ArrayList<>();
    String TYPE = "Smartphone";

    public SmartphoneViewModel()
    {
        SmartphoneLiveData = new MutableLiveData<>();
        init();
    }
    public void init()
    {
        populateList();
        SmartphoneLiveData.setValue(products);
    }
    public MutableLiveData<ArrayList<Product>> getUserMutableLiveData(){
        return SmartphoneLiveData;
    }

    public void populateList()
    {
        NetworkService.getInstance().getApi().GetCatalog(TYPE).enqueue(new Callback<ArrayList<Product>>() {
            @Override
            public void onResponse(Call<ArrayList<Product>> call, Response<ArrayList<Product>> response) {
                SmartphoneLiveData.postValue(response.body());
            }
            @Override
            public void onFailure(Call<ArrayList<Product>> call, Throwable t) {

            }
        });
    }
}
