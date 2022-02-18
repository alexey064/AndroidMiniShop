package com.example.myapplication.ViewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.NetworkService;

import java.util.ArrayList;

import Models.linked.Product;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WirelessHeadphonesViewModel extends ViewModel {
    MutableLiveData<ArrayList<Product>> WirelessHeadphonesLiveData;
    private String TYPE="WirelessHeadphone";
    public WirelessHeadphonesViewModel()
    {
        WirelessHeadphonesLiveData = new MutableLiveData<>();
        init();
    }
    public MutableLiveData<ArrayList<Product>> getWirelessHeadphonesLiveData()
    {
        return WirelessHeadphonesLiveData;
    }

    public void init()
    {
        NetworkService.getInstance().getApi().GetCatalog(TYPE).enqueue(new Callback<ArrayList<Product>>() {
            @Override
            public void onResponse(Call<ArrayList<Product>> call, Response<ArrayList<Product>> response) {
                WirelessHeadphonesLiveData.postValue(response.body());
            }
            @Override
            public void onFailure(Call<ArrayList<Product>> call, Throwable t) {

            }
        });
    }
}
